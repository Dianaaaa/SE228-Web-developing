package com.retell.retellbackend.serviceimpl;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.model.GridFSUploadOptions;
import com.mongodb.gridfs.GridFS;
import com.retell.retellbackend.service.BookimgService;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Null;
import java.io.IOException;
import java.io.InputStream;

@Service
public class BookimgServiceImpl implements BookimgService {
//    @Autowired
//    private MongoDbFactory mongodbfactory;

    public byte[] getfile(String fileid) {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase myDatabase = mongoClient.getDatabase("retell");

        GridFSBucket gridFSBucket = GridFSBuckets.create(myDatabase, "imgs");

        ObjectId fileId = new ObjectId(fileid); //The id of a file uploaded to GridFS, initialize to valid file id
        GridFSDownloadStream downloadStream = gridFSBucket.openDownloadStream(fileId);
        int fileLength = (int) downloadStream.getGridFSFile().getLength();
        byte[] bytesToWriteTo = new byte[fileLength];
        downloadStream.read(bytesToWriteTo);
        downloadStream.close();
        return bytesToWriteTo;
    }

    public String uploadfile(MultipartFile file){

        MongoClient mongoClient = new MongoClient();
        MongoDatabase myDatabase = mongoClient.getDatabase("retell");

        GridFSBucket gridFSBucket = GridFSBuckets.create(myDatabase, "imgs");

        try{
            InputStream in = file.getInputStream();
            String name = file.getOriginalFilename();

            GridFSUploadOptions options = new GridFSUploadOptions()
                    .chunkSizeBytes(358400)
                    .metadata(new Document("type", "presentation"));

            ObjectId fileId = gridFSBucket.uploadFromStream(name, in, options);
            System.out.println(fileId);
            return fileId.toHexString();

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
