package com.retell.retellbackend.serviceimpl;

import javax.annotation.Resource;

import com.retell.retellbackend.repository.BookRepository;
import com.retell.retellbackend.repository.CartRepository;
import com.retell.retellbackend.repository.CategoryRepository;
import com.retell.retellbackend.repository.UserRepository;
import com.retell.retellbackend.entity.Book;
import com.retell.retellbackend.entity.Cart;
import com.retell.retellbackend.entity.Category;
import com.retell.retellbackend.entity.UserEntity;
import com.retell.retellbackend.service.SeedService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class SeedServiceImpl implements SeedService {
    @Resource
    private BookRepository bookRepository;

    @Resource
    private CategoryRepository cateRepository;

    @Resource
    private UserRepository userRepository;

    @Resource
    private CartRepository cartRepository;

    public void seed() {
        UserEntity admin = new UserEntity();
        admin.setID(1);
        admin.setUsername("admin");
        String password = new BCryptPasswordEncoder().encode("123456");
        admin.setPassword(password);
        admin.setRole("ADMIN");
        admin.setEmail("1035254583@qq.com");
        admin.setStatus(1);
        admin.setAvator("http://localhost:8080/resources/avator2.jpg");
        userRepository.save(admin);
        Cart cart1 = new Cart();
        cart1.setID(1);
        cart1.setUser(admin);
        cartRepository.save(cart1);

        Category cate1 = new Category();
        cate1.setID(1);
        cate1.setName("计算机");
        cateRepository.save(cate1);
        Category cate2 = new Category();
        cate2.setID(2);
        cate2.setName("小说");
        cateRepository.save(cate2);
        Category cate3 = new Category();
        cate3.setID(3);
        cate3.setName("文学");
        cateRepository.save(cate3);
        Category cate4 = new Category();
        cate4.setID(4);
        cate4.setName("人文社科");
        cateRepository.save(cate4);
        Category cate5 = new Category();
        cate5.setID(5);
        cate5.setName("医学");
        cateRepository.save(cate5);
        Category cate6 = new Category();
        cate6.setID(6);
        cate6.setName("教辅");
        cateRepository.save(cate6);
        Category cate7 = new Category();
        cate7.setID(7);
        cate7.setName("艺术");
        cateRepository.save(cate7);
        Category cate8 = new Category();
        cate8.setID(8);
        cate8.setName("生活");
        cateRepository.save(cate8);
        Category cate9 = new Category();
        cate9.setID(9);
        cate9.setName("进口原版");
        cateRepository.save(cate9);


//        Book book1 = new Book();
//        book1.setID();
//        book1.setName();
//        book1.setAuthor();
//        book1.setISBN();
//        book1.setStock();
//        book1.setFrontpage();
//        book1.setCategory(cate1);
//        book1.setBookDetail();
//        book1.setAuthorDetail();
//        book1.setCurCost(BigDecimal.valueOf());
//        book1.setPrevCost(BigDecimal.valueOf());
//        bookRepository.save();


        Book book1 = new Book();
        book1.setID(1);
        book1.setName("机器学习");
        book1.setAuthor("周志华");
        book1.setISBN("123456");
        book1.setStock(98);
        book1.setFrontpage("http://localhost:8080/resources/ml.jpg");
        book1.setCategory(cate1);
        book1.setBookDetail("ACM数据挖掘中国分会点评周志华教授的专著《机器学习》\n2016-02-05 KDD China CKDD\n南京大学周志华教授撰写的《机器学习》（清华大学出版社）上架不到一周即成为亚马逊*\n畅销商品，各网站上现货被抢购一空，一时间“洛阳纸贵”。技术类书籍热卖到此程度，相\n\n当罕见。ACM数据挖掘中国分会部分专家仔细研读了这本专著，给出如下评价：\n\n\n全书16章，附带相关矩阵、优化、概率知识的附录，共425页，62.6万字。中国计算机学会\n终身成就奖得主陆汝钤院士作序，书后有作者自撰后记。该书有以下特点：\n1. 内容系统全面。全书16章，覆盖了机器学习几乎所有的主要分支领域，覆盖面超过了该\n领域国际著名书籍如ESL与PRML：** 部分（**-3 章）介绍机器学习的基础知识；第2 部");
        book1.setAuthorDetail("周志华，南京大学计算机系教授，ACM杰出科学家，IEEE Fellow, IAPR Fellow, IET/IEE Fellow, 中国计算机学会会士。国家杰出青年科学基金获得者、长江学者特聘教授。先后担任多种SCI(E)期刊执行主编、副主编、副编辑、编委等。中国计算机学会人工智能与模式识别专业委员会主任，中国人工智能学会机器学习专业委员会主任，IEEE计算智能学会数据挖掘技术委员会副主席。");
        book1.setCurCost(BigDecimal.valueOf(22.00));
        book1.setPrevCost(BigDecimal.valueOf(45.00));
        bookRepository.save(book1);
        Book book2 = new Book();
        book2.setID(2);
        book2.setName("算法（第4版）（图灵图书）");
        book2.setAuthor("Robert Sedgewick, Kevin Wayne");
        book2.setISBN("9787115293800");
        book2.setStock(98);
        book2.setFrontpage("http://localhost:8080/resources/2.jpg");
        book2.setCategory(cate1);
        book2.setBookDetail("《图灵程序设计丛书:算法(第4版)》编辑推荐：Sedgewick之巨著，与高德纳TAOCP一脉相承，几十年多次修订，经久不衰的畅销书，涵盖所有程序员必须掌握的50种算法。《图灵程序设计丛书:算法(第4版)》全面讲述算法和数据结构的必备知识，具有以下几大特色：\n" +
                "算法领域的经典参考书：Sedgewick畅销著作的最新版，反映了经过几十年演化而成的算法核心知识体系。\n" +
                "内容全面：全面论述排序、搜索、图处理和字符串处理的算法和数据结构，涵盖每位程序员应知应会的50种算法。\n" +
                "全新修订的代码：全新的Java实现代码，采用模块化的编程风格，所有代码均可供读者使用。\n" +
                "与实际应用相结合：在重要的科学、工程和商业应用环境下探讨算法，给出了算法的实际代码，而非同类著作常用的伪代码。\n" +
                "富于智力趣味性：简明扼要的内容，用丰富的视觉元素展示的示例，精心设计的代码，详尽的历史和科学背景知识，各种难度的练习，这一切都将使读者手不释卷。\n" +
                "科学的方法：用合适的数学模型精确地讨论算法性能，这些模型是在真实环境中得到验证的。\n" +
                "与网络相结合：配套网站algs4.cs.princeton.edu提供了本书内容的摘要及相关的代码、测试数据、编程练习、教学课件等资源。");
        book2.setAuthorDetail("作者：（美国）塞奇威克（Robert Sedgewick）^韦恩（Kevin Wayne） 译者：谢路云\n" +
                "\n" +
                "塞奇威克（Robert Sedgewick），斯坦福大学博士，导师为Donald E. Knuth，从1985年开始一直担任普林斯顿大学计算机科学系教授，曾任该系主任，也是Adobe Systems公司董事会成员，曾在Xerox PARC、国防分析研究所（institute for Defense Analyses）和法国国家信息与自动化研究所（INRIA）从事研究工作。他的研究方向包括解析组合学、数据结构和算法的分析与设计、程序可视化等。\n" +
                "韦恩（Kevin Wayne），康奈尔大学博士，普林斯顿大学计算机科学系高级讲师，研究方向包括算法的设计、分析和实现，特别是图和离散优化。");
        book2.setCurCost(BigDecimal.valueOf(80.60));
        book2.setPrevCost(BigDecimal.valueOf(99.00));
        bookRepository.save(book2);
        Book book3 = new Book();
        book3.setID(3);
        book3.setName("深度学习：智能时代的核心驱动力量");
        book3.setAuthor("谢诺夫斯基");
        book3.setISBN("9787508698359");
        book3.setStock(83);
        book3.setFrontpage("http://localhost:8080/resources/3.jpg");
        book3.setCategory(cate1);
        book3.setBookDetail("编辑推荐\n" +
                "★ 【不是所有写深度学习的书你都能读得懂。】以堪比文学书的流畅，引领你了解人工智能井喷式发展的真相。\n" +
                "★ 【深度学习会扩大你的认知，人工智能不是生存威胁。】这本书所讲的内容，与每个人的生活息息相关。AlphaGo、自动驾驶、语音识别、智能翻译、AI医疗、图像识别……你所看到的各种形式的人工智能，背后都是深度学习在发挥作用。这本书将告诉你，深度学习有哪些神奇之处，并对你产生哪些影响。\n" +
                "★ 【人工智能大牛作者重磅作品】世界十大AI科学家之一、美国“四院院士”（全美在世仅3位）、全球人工智能专业会议NIPS基金会主席特伦斯·谢诺夫斯基（Terrence/Terry Sejnowski）力作。\n" +
                "★ 【AI女神、AI教父联袂推荐】谷歌前云AI负责人、斯坦福大学HAI研究院联合创始人 李飞飞、AI教父杰弗里·辛顿诚挚推荐\n" +
                "★ 【风靡全球，多语种同步上市】风靡全球的智能时代前沿读本，全景展示深度学习的发展与应用。被翻译成多国语言，300万+用户一致好评。\n" +
                "★ 【想了解深度学习，读这本就够了。】很多信息都在传递AI会给我们带来革命性的巨变，却只点出了表象，而这本书将从AI的源头——深度学习开始，讲述这个智能时代核心驱动力量如何一步步影响科技、商业乃至整个世界的进步。\n" +
                "名人推荐\n" +
                "\"特伦斯是一名杰出的神经科学家，我们于1986年共同发明了玻尔兹曼机。\n" +
                "——AI教父 杰弗里·辛顿\n" +
                "\n" +
                "人工智能是科技王冠上的钻石，而深度学习代表了其中一个承上启下的重要阶段。这本书有助于在我们心目中更加清晰准确地绘制人工智能的未来图景。你可以从本书中了解到那些令人惊讶，甚至于有些担忧的科技进展，大致了解它们背后的原理。这展现了人工智能相对于人类而言的单方面优势。你也能看到许多真实事例，反映了人工智能相对于人类而言的“笨拙”。在现实中，这种“笨拙”的情况往往更加普遍。这些事例有时令人忍俊不禁，它恰恰体现了我们人类的大脑是多么精妙的设计。\n" +
                "——微软小冰之父、微软（亚洲）互联网工程院副院长 李笛 \n" +
                "\n" +
                "特伦斯·谢诺夫斯基作为深度学习领域的先驱，带领该领域由理论命题走向实证科学。这是一大飞跃。\n" +
                "——诺贝尔生理学或医学奖得主 埃里克·坎德尔\n" +
                "\n" +
                "作为深度学习领域的亲历者，以及深度学习灵魂人物的同行者，谢诺夫斯基分享了这一技术发展过程中的洞见和轶事。这本书记录了人工智能这场狂飙运动，字里行间都能感受到作者的兴奋和投入。\n" +
                "——互联网之父、谷歌副总裁 文顿·瑟夫\n" +
                "\n" +
                "人工智能正在觉醒，世界正在被重塑。深度学习正是这一变化背后的驱动力。特伦斯·谢诺夫斯基扎根该领域研究30年，是绝对的先驱。如果你想了解人工智能，必读此书。\n" +
                "——麻省理工学院斯隆商学院教授 埃里克·布林约尔夫松");
        book3.setAuthorDetail("特伦斯·谢诺夫斯基 Terrence (Terry) Sejnowski \n" +
                "\n" +
                "世界十大AI科学家之一，美国四大国家学院（国家科学院、国家医学院、国家工程院、国家艺术与科学学院）在世仅3位的“四院院士”之一，全球AI专业会议NIPS基金会主席。\n" +
                "\n" +
                "作为神经网络的先驱，早在1986年，特伦斯就与杰弗里·辛顿共同发明了玻尔兹曼机，把神经网络带入到研究与应用的热潮，将深度学习从边缘课题变成了互联网科技公司仰赖的核心技术，实现了人工智能井喷式的发展。\n" +
                "\n" +
                "特伦斯现任美国索尔克生物研究所(美国生命科学领域成果最多的研究机构) 计算神经生物学实验室主任，是美国政府注资50亿美元“脑计划”项目（BRAIN，the Brain Research through Advancing Innovative Neurotechnologies）领军人物。\n" +
                "\n" +
                "特伦斯同时是全球最大在线学习平台Coursera很受欢迎课程《学习如何学习》（Learning how to learn）主理人，通过系统讲解大脑认知的底层知识，让学习者可以改变思维模式，提高学习的能力和效率。目前该课程学习人数已经超过了300万。");
        book3.setCurCost(BigDecimal.valueOf(51.92));
        book3.setPrevCost(BigDecimal.valueOf(88.00));
        bookRepository.save(book3);

        Book book4 = new Book();
        book4.setID(4);
        book4.setName("人间失格");
        book4.setAuthor("太宰治");
        book4.setISBN("7505738143");
        book4.setStock(88);
        book4.setFrontpage("http://localhost:8080/resources/10.jpg");
        book4.setCategory(cate2);
        book4.setBookDetail("·日本“无赖派”文学大师太宰治完整代表作集结，一部纯粹的“私小说”，太宰治的灵魂之书\n" +
                "\n" +
                "·太宰治是日本文学史上一个备受争议的作家，他39岁便自杀身亡，一生命运多舛，良作颇多，《人间失格》是他人生中的收官之作，很具有研究价值。\n" +
                "\n" +
                "·五次自杀，天鹅绝唱，纤细的自传体中透露出顶峰的颓废，毁灭式的绝笔之作。");
        book4.setAuthorDetail("太宰治（1909-1948），本名津岛修治，日本无赖派文学大师，1933年开始用太宰治为笔名写作他五次自杀未遂，于1948年，在《人间失格》发表后，和女读者于玉川上水道投水自尽。太宰治在短暂的写作生涯中创作了三十多部小说，早期包括《晚年》《虚构的彷徨》《二十世纪旗手》等深受注目，另有《满愿》《越级诉讼》等多部名作。为了生活，他曾以“黑木舜平”的笔名写了心理悬疑小说《断崖的错觉》，但太宰本身以此作品为耻。在他的作品中，中篇《斜阳》《人间失格》堪称日本战后文学的金字塔之巅。");
        book4.setCurCost(BigDecimal.valueOf(18.88));
        book4.setPrevCost(BigDecimal.valueOf(32.00));
        bookRepository.save(book4);

        Book book5 = new Book();
        book5.setID(5);
        book5.setName("局外人");
        book5.setAuthor("加缪");
        book5.setISBN("755942743X");
        book5.setStock(50);
        book5.setFrontpage("http://localhost:8080/resources/xx.jpg");
        book5.setCategory(cate3);
        book5.setBookDetail("（1）青年法语译者全新译本，展现《局外人》语言魅力。（2）这一次终于读懂了《局外人》——法国索邦大学文学博士原创万字导读，独特角度讲解《局外人》。（3）韩国知名设计师为《局外人》情节原创彩插，中文版授权。（4）收录1956年美国版《局外人》加缪亲笔序言，收录1957年加缪在诺贝尔颁奖酒会上的演讲词，收录加缪珍贵照片资料。（5）在人类文学史上，诺贝尔文学奖得主加缪的荒诞主义代表作《局外人》，以其独特的视角展示世界的荒诞性，成为二十世纪整个西方文坛具有划时代意义的伟大作品。");
        book5.setAuthorDetail("阿尔贝·加缪(1913-1960）Albert Camus\n" +
                "“存在主义”文学大师\n" +
                "“荒诞哲学”的代表作家\n" +
                "阿尔贝·加缪，法国著名作家、哲学家、文学理论家。1942年，他凭借《局外人》一举成名。1957年，因为“他的重要文学创作以明彻的认真态度阐明了我们这个时代人类良知的问题”，加缪获得了诺贝尔文学奖。1960年，他在前往巴黎的途中遭遇车祸身亡，年仅47岁。\n" +
                "加缪的作品始终从人的现实生存困境出发，揭示了世界的荒诞性。他主张人类要直面荒诞，并且在荒诞中奋起反抗，坚持真理和正义。这一思想使他成为二战后欧洲乃至全世界几代青年的“精神导师”。");
        book5.setCurCost(BigDecimal.valueOf(26.55));
        book5.setPrevCost(BigDecimal.valueOf(45.00));
        bookRepository.save(book5);

        Book book6 = new Book();
        book6.setID(6);
        book6.setName("德国极简史");
        book6.setAuthor("詹姆斯·霍斯 (James Hawes)");
        book6.setISBN("9787540489120");
        book6.setStock(100);
        book6.setFrontpage("http://localhost:8080/resources/19.jpg");
        book6.setCategory(cate4);
        book6.setBookDetail("作者：（英国）詹姆斯·霍斯（James Hawes）\n" +
                "\n" +
                "英国小说家、历史学家。出生于1960年。在牛津大学赫特福德学院学习德语，毕业后在威尔士短暂研习戏剧，而后前往西班牙任英语老师。1987至1989年，在伦敦大学学院攻读博士学位，研究方向是尼采和德国文学。其后在梅努斯大学、谢菲尔德大学和斯旺西大学担任德语讲师。目前负责布鲁克斯大学创意写作课程。\n" +
                "霍斯出版了6部小说，其中两本被改编为电影剧本。《为英格兰辩护》预言了英国脱欧事件，传记作品《卡夫卡考》引起巨大轰动。《英国佬与德国佬》从全新角度审视19世纪后期英国和德国的关系。\n" +
                "新作《德国极简史》广受好评，一度位列《星期日泰晤士报》大众平装书榜榜单第二名。《经济学家》称之为“必读书”，水石书店将其列为全英月度非虚构类好书。");
        book6.setAuthorDetail("《德国极简史》出版后即荣登欧美各大国际媒体、书店的销量榜，成为备受瞩目的年度历史类图书，所获成绩包括：《星期日泰晤士报》周销量榜No.2，仅次于《人类简史》；《泰晤士报》销量榜首；《星期日泰晤士报》年度销量总榜Top 10；长期位列德国《明镜周刊》销量榜单；水石书店月度非虚构类好书……\n" +
                "《黄金罗盘》作者菲利普·普尔曼盛赞：“全面而生动，没有比本书更好的德国简史了。”《经济学人》《卫报》《泰晤士报》《明镜周刊》《旁观者》等众多媒体推荐：“精彩”“文采斐然”“有趣”“你一定爱读的《德国极简史》”。剑桥大学、牛津大学等国际一流院校学者、教授一致推荐：“一次令人兴奋的阅读体验”“扎实的研究和彻底的反思”。 \n" +
                "以200多页的精悍叙述、100多张生动配图，展现了公元前58年至今近2000年间，以日耳曼民族为主体的德意志人的历史进程，把德国历史放在欧洲乃至西方世界的大背景中观察、分析、探究，从欧洲纵横交错的小国割据和日耳曼人众多分支的发展中，对现代德国的历史脉络进行追踪和梳理，选取了影响德国历史进程的重大事件、关键时刻，勾勒德意志民族和德国的发展轮廓。理论新颖、明白晓畅。");
        book6.setCurCost(BigDecimal.valueOf(33.04));
        book6.setPrevCost(BigDecimal.valueOf(56.00));
        bookRepository.save(book6);

        Book book7 = new Book();
        book7.setID(7);
        book7.setName("阿司匹林传奇");
        book7.setAuthor("迪尔米德·杰弗里斯(Diarmuid Jeffreys)");
        book7.setISBN("7108034093");
        book7.setStock(100);
        book7.setFrontpage("http://localhost:8080/resources/21.jpg");
        book7.setCategory(cate5);
        book7.setBookDetail("《阿司匹林传奇》是新知文库。");
        book7.setAuthorDetail("作者：（英国）迪尔米德·杰弗里斯（Diarmuid Jeffreys） 译者：暴永宁 王惠\n" +
                "\n" +
                "迪尔米德·杰弗里斯（Diarmuid Jeffreys），英国作家、记者、电视制片人，供职于英国广播公司（BBC）.");
        book7.setCurCost(BigDecimal.valueOf(51.92));
        book7.setPrevCost(BigDecimal.valueOf(65.00));
        bookRepository.save(book7);

        Book book8 = new Book();
        book8.setID(8);
        book8.setName("ABC幼儿双语启蒙认知绘本");
        book8.setAuthor("赵君");
        book8.setISBN("7541483354");
        book8.setStock(100);
        book8.setFrontpage("http://localhost:8080/resources/23.jpg");
        book8.setCategory(cate6);
        book8.setBookDetail("1.认知方向明确——八个针对性日常趣味小故事，八大成长必备认知本领（数字、形状、颜色、分类、感觉、方位、对比、服饰）全面启蒙。\n" +
                "2.英文简单易懂——中英双语，英语为主，能够让宝宝从认知开始就接触基础的英语词汇，在认知中提升语感，进行左右脑思维开发训练，同时拥有双母语。\n" +
                "3.重点词汇突出——针对认知点的中英文重点词汇均做了单独突出，便于孩子重点掌握，强化记忆。\n" +
                "4.故事好玩有趣——画面童趣温馨，色彩鲜艳，故事惊喜不断，能够刺激宝宝的视觉与想象力，全方位锻炼孩子的认知能力，并且让孩子爱上阅读。\n" +
                "5.亲子互动性强——故事贴近日常，父母可以根据绘本中的故事自行发挥，通过绘本中的方式延伸与孩子的互动游戏，强化孩子的认知记忆。");
        book8.setCurCost(BigDecimal.valueOf(73.00));
        book8.setPrevCost(BigDecimal.valueOf(120.00));
        bookRepository.save(book8);

        Book book9 = new Book();
        book9.setID(9);
        book9.setName("鸡是半圆形,猫是圆形");
        book9.setAuthor("罗莎•玛丽亚•柯托（Rosa M.Curto）");
        book9.setISBN("9787548416593");
        book9.setStock(100);
        book9.setFrontpage("http://localhost:8080/resources/25.jpg");
        book9.setCategory(cate7);
        book9.setBookDetail("《鸡是半圆形，猫是圆形》8种几何图形的创意简笔画。萌翻欧美的创意简笔画，一分钟画出萌物，令人脑洞大开、全面发散思维。\n" +
                "★ 什么？！鸡是半圆形？猫是圆形？本书让热爱画画的你脑洞大开\n" +
                "★ 天马行空，创意无限！来自西班牙萌翻全世界的快乐简笔画入门\n" +
                "★ 全彩色印刷，老少皆宜，一学就会！赶快开启一段奇妙的绘画旅程吧");
        book9.setAuthorDetail("作者：罗莎•玛丽亚•柯托（Rosa M.Curto），西班牙著名插画家，自19岁起开始担任儿童绘画教师，她多样化的插图遍布于儿童读物、卡通电影、广告和杂志上，其作品在美国、英国、阿根廷、比利时、巴西、丹麦等30多个国家都可看到。目前已出版的儿童绘本作品多达40本以上。");
        book9.setCurCost(BigDecimal.valueOf(37.60));
        book9.setPrevCost(BigDecimal.valueOf(69.80));
        bookRepository.save(book9);

        Book book10 = new Book();
        book10.setID(10);
        book10.setName("世界咖啡地图(全球公认的咖啡圣经,咖啡迷心念收藏的终极指南,世界咖啡师大赛冠军代表作) ");
        book10.setAuthor("詹姆斯·霍夫曼（James Hoffmann）");
        book10.setISBN("9787508661148");
        book10.setStock(100);
        book10.setFrontpage("http://localhost:8080/resources/27.jpg");
        book10.setCategory(cate8);
        book10.setBookDetail("《世界咖啡地图》是全球公认的咖啡圣经！雄踞美国、英国等国亚马逊网站咖啡类图书榜首，荣登《经济学人》年度饮食类图书榜。作者詹姆斯•霍夫曼，2007年世界咖啡师大赛冠军，他走遍全球各大产区搜集一手信息。儒雅的他，以贴近读者的方式娓娓道来，带领大家探索咖啡世界的奥秘，帮助入门者轻松建立整体知识框架，使资深者受益于所分享的心得经验。\n" +
                "书中以卓越的见解，讲述关于咖啡的一切：咖啡的历史和全球产业链、采收及加工处理、烘焙与冲煮方式、29大产区的特色详解……《世界咖啡地图》系统全面、语言优美、见解精妙，是咖啡迷必备的权威百科全书。\n" +
                "《世界咖啡地图》是一本美丽的咖啡全球指南，封面采用仿咖啡豆袋纸，手感十足；内文收录有上百幅全彩图片、地图和插画，是令咖啡迷们爱不释手、心念收藏的经典工具书。\n" +
                "\n" +
                "一本有态度有内涵又有颜值的咖啡百科书。\n" +
                "\n" +
                "先是爱上这本书的颜值，仿咖啡豆麻袋纸的封面一下就把人带入到咖啡的世界，书内配图也都有着十足的质感。细细读来，又发现内容同样精彩，从一颗生豆到一杯咖啡，你所能想到的关于咖啡的种种问题相信都能在这本书中找到答案，而且重要的是，语言完全不枯燥，有趣且好读。不过让我觉得最赞的是作者在书中流露出的认真严谨且毫不浮夸的写书态度。作为2007年在世界咖啡师大赛（WBC）的冠军，詹姆斯客观考究的讲解着关于咖啡的一切，细节中处处蕴含着作者的认真与幽默。相信这本书会是带你踏入咖啡世界大门的好伙伴。\n" +
                "——亚马逊王大强");
        book10.setAuthorDetail("英)詹姆斯·霍夫曼（James Hoffmann），著名咖啡师、烘焙专家，咖啡界传奇人物。\n" +
                "2007年在世界咖啡师大赛（WBC）荣获冠军，2008年赢得英国杯测大赛冠军，2011年拿下英国手冲杯冠军。后在伦敦与朋友一同创办了知名的Square Mile咖啡烘焙品牌，培育出独特的伦敦咖啡文化。近年与Nuova Simonelli合作，设计研发出划时代的黑鹰咖啡机，极大地提高了咖啡出品的稳定性，成为众多咖啡师赞不绝口的利器。");
        book10.setCurCost(BigDecimal.valueOf(116.82));
        book10.setPrevCost(BigDecimal.valueOf(198.00));
        bookRepository.save(book10);

        Book book11 = new Book();
        book11.setID(11);
        book11.setName("Harry Potter: The Complete Collection (English Edition)");
        book11.setAuthor("J.K. Rowling");
        book11.setISBN("1408856786");
        book11.setStock(50);
        book11.setFrontpage("http://localhost:8080/resources/29.jpg");
        book11.setCategory(cate9);
        book11.setBookDetail("I've yet to meet a ten-year-old who hasn't been entranced by its witty, complex plot and the character of the eponymous Harry * Independent * Spellbinding, enchanting, bewitching stuff * Mirror * Teachers say a chapter can silence the most rowdy of classes * Guardian * One of the greatest literary adventures of modern times * Sunday Telegraph * The Harry Potter stories will join that small group of children's books which are read and reread into adulthood * TLS *");
        book11.setAuthorDetail("Harry Potter and the Philosopher's Stone was J.K. Rowling's first novel, followed by the subsequent six titles in the Harry Potter series, as well as three books written for charity: Fantastic Beasts and Where to Find Them, Quidditch Through the Ages and The Tales of Beedle the Bard. The Harry Potter novels have now sold over 450 million copies worldwide and been translated into 77 languages.");
        book11.setCurCost(BigDecimal.valueOf(697.00));
        book11.setPrevCost(BigDecimal.valueOf(697.00));
        bookRepository.save(book11);

        Book book12 = new Book();
        book12.setID(12);
        book12.setName("C++ Primer Plus中文版(第6版)");
        book12.setAuthor("蒂芬•普拉达 (Stephen Prata)");
        book12.setISBN("9787115279460");
        book12.setStock(99);
        book12.setFrontpage("http://localhost:8080/resources/6.jpg");
        book12.setCategory(cate1);
        book12.setBookDetail("一本经久不衰的C++畅销经典教程；一本支持C++11新标准的程序设计图书。 \n" +
                "　　它被誉为“开发人员学习C++的教程，没有之一”！ Amazon网站“Language”类销售排名第三的超级畅销书，之前版本在美国销售超10万！ \n" +
                "　　《C++ Primer Plus(第6版)中文版》可以说是一本面向从未学习过C语言甚到是从未学习过编程的人的入门书籍，它的一章从基础内容讲起，先介绍了传统编程的规则，后面才着重讲解有关面向对象——C++的精髓之一——的有关内容。整个书的结构安排较为合理，难度爬升较慢。 \n" +
                "　　如果你是一个从未学过C语言（或者压根没学会C）的读者，那么，我相信这本书更适合你。\n" +
                "\n" +
                "媒体推荐");
        book12.setAuthorDetail("Stephen Prata，在美国加州肯特菲尔得的马林学院教授天文、物理和计算机科学。他毕业于加州理工学院，在美国加州大学伯克利分校获得博士学位。他单独或与他人合作编写的编程图书有十多本，其中《New C Primer Plus》获得了计算机出版联合会1990年度“How-to”计算机图书奖，《C++ Primer Plus》获得了计算机出版联合会1991年度“How-to”计算机图书奖提名。");
        book12.setCurCost(BigDecimal.valueOf(81.40));
        book12.setPrevCost(BigDecimal.valueOf(99.00));
        bookRepository.save(book12);

        Book book13 = new Book();
        book13.setID(13);
        book13.setName("Effective C++:改善程序与设计的55个具体做法(第3版)(中文版)");
        book13.setAuthor("梅耶(Scott Meyers),侯捷");
        book13.setISBN("7121123320");
        book13.setStock(100);
        book13.setFrontpage("http://localhost:8080/resources/7.jpg");
        book13.setCategory(cate1);
        book13.setBookDetail("《Effective C++:改善程序与设计的55个具体做法(第3版)(中文版)(双色)》前两个版本抓住了全世界无数程序员的目光。原因十分明显：Scott Meyers极富实践意义的C++研讨方式，描述出专家用以产出干净、正确、高效代码的经验法则和行事法则——也就是他们几乎总是做或不做的某些事。\n" +
                "《Effective C++:改善程序与设计的55个具体做法(第3版)(中文版)(双色)》一共组织55个准则，每一条准则描述一个编写出更好的C++的方式、每一个条款的背后都有具体范例支撑。第三版有一半以上的篇幅是崭新内容，包括讨沦资源管理和模块（templates）运用的两个新章。为反映出现代设计考虑，对第二版论题做了广泛的修订，包括异常（exceptions）、没汁模式（design patterns）和多线程（multithreading）。\n" +
                "高效的Classes、functions、templates和inheritance hierarchies（继承体系）方面的专家级指导。\n" +
                "崭新的“TR1”标准程序库功能应用，以及与既有标准程序库组件的比较。\n" +
                "洞察C++和其他语言（例如Java、C＃、C）之间的不同。此举有助于那些来自其他语言阵营的开发人员消化吸收C++式的各种解法。");
        book13.setAuthorDetail("作者：（美国）梅耶(Scott Meyers) 译者：侯捷\n" +
                "\n" +
                "梅耶（Scott Meyers），是全世界最知名的C++软件开发专家之一。他是畅销书《Effective C++》系列（Effective C++，More Effective C++，Effective STL）的作者，又是创新产品《Effective C++CD》的设计者和作者，也是Addison-wesley的“Effective Software Development Series”顾问编辑，以及《Software Development》杂志咨询板成员。他也为若干新公司的技术咨询板提供服务。Meyers于1993年自Brown大学获得计算机博土学位。\n" +
                "侯捷，是计算机技术书籍的作家、泽者、书评人。著有《深入浅出MFC》、《多犁与虚拟》、《STL源码剖析》、《无责任书评》三卷，泽有众多脍炙人口的高阶技术书籍，包括Meyers所著的“Effective C++”系列。侯捷兼任教职于元智大学、同济大学、南京大学。");
        book13.setCurCost(BigDecimal.valueOf(53.70));
        book13.setPrevCost(BigDecimal.valueOf(65.00));
        bookRepository.save(book13);

        Book book14 = new Book();
        book14.setID(14);
        book14.setName("微服务设计 (图灵程序设计丛书)");
        book14.setAuthor("纽曼(Sam Newman)");
        book14.setISBN("B01ER75V6O");
        book14.setStock(100);
        book14.setFrontpage("http://localhost:8080/resources/8.jpg");
        book14.setCategory(cate1);
        book14.setBookDetail("本书全面介绍了微服务的建模、集成、测试、部署和监控，通过一个虚构的公司讲解了如何建立微服务架构。主要内容包括认识微服务在保证系统设计与组织目标统一上的重要性，学会把服务集成到已有系统中，采用递增手段拆分单块大型应用，通过持续集成部署微服务，等等。 ");
        book14.setAuthorDetail("");
        book14.setCurCost(BigDecimal.valueOf(55.20));
        book14.setPrevCost(BigDecimal.valueOf(65.00));
        bookRepository.save(book14);

        Book book15 = new Book();
        book15.setID(15);
        book15.setName("算法导论(原书第3版)");
        book15.setAuthor("Thomas H.Cormen, Charles E.Leiserson, Ronald L.Rivest, Clifford Stein");
        book15.setISBN("9787111407010");
        book15.setStock(100);
        book15.setFrontpage("http://localhost:8080/resources/9.jpg");
        book15.setCategory(cate1);
        book15.setBookDetail("鉴于数据量的爆炸性增长，和计算应用的多样性，现在比以往更需要有效算法。这本书条理清晰，是一本非常好的算法设计与分析方面的导论性书籍。每章前半部分介绍了讲授和学习算法的有效方法，后半部分为更专业的读者和求知欲强的学生提供了更引人入胜的资料来讨论这个迷人领域的各种可能性和挑战。\n" +
                "——Shang-Hua Teng（腾尚华），南加州大学维特比工学院计算机系Seeley G. Mudd 教授\n" +
                "本书是算法领域的一部经典著作，书中系统、全面地介绍了现代算法：从最快算法和数据结构到用于看似难以解决问题的多项式时间算法；从图论中的经典算法到用于字符匹配、计算集合和数论的特殊算法。本书第3版尤其增加了两章专门讨论van Emde Boas树（最有用的数据结构之一）和多线程算法（日益重要的一个主题）。\n" +
                "——Daniel Spielman，耶鲁大学计算机科学和应用数学Henry Ford II教授\n" +
                "作为一个在算法领域有着近30年教育和研究经验的教育者和研究人员，我可以清楚明白地说这本书是我所见到的该领域最好的教材。它对算法给出了清晰透彻、百科全书式的阐述。我们将继续使用这本书的新版作为研究生和本科生的教材和可以信赖的研究参考书。\n" +
                "——Gabriel Robins，弗吉尼亚大学工程和应用科学学院计算机科学系教授");
        book15.setAuthorDetail("作者：（美国）托马斯•科尔曼（Thomas H.Cormen） （美国）查尔斯•雷瑟尔森（Charles E.Leiserson） （美国）罗纳德•李维斯特（Ronald L.Rivest） （美国）克利福德•斯坦（Clifford Stein） 译者：王刚 邹恒明 殷建平 王宏志 等\n" +
                "\n" +
                "托马斯•科尔曼（Thomas H. Cormen）达特茅斯学院计算机科学系教授、系主任。目前的研究兴趣包括：算法工程、并行计算、具有高延迟的加速计算。他分别于1993年、1986年获得麻省理工学院电子工程和计算机科学博士、硕士学位，师从Charles E. Leiserson教授。由于他在计算机教育领域的突出贡献，Cormen教授荣获2009年ACM杰出教员奖。\n" +
                "查尔斯•雷瑟尔森（Charles E. Leiserson）麻省理工学院计算机科学与电气工程系教授，Margaret MacVicar Faculty Fellow。他目前主持MIT超级计算技术研究组，并是MIT计算机科学和人工智能实验室计算理论研究组的成员。他的研究兴趣集中在并行和分布式计算的理论原理，尤其是与工程现实相关的技术研究。Leiserson教授拥有卡内基•梅隆大学计算机科学博士学位，还是ACM、IEEE和SIAM的会士。\n" +
                "罗纳德•李维斯特（Ronald L. Rivest）现任麻省理工学院电子工程和计算机科学系安德鲁与厄纳•维特尔比（Andrew and Erna Viterbi）教授。他是MIT计算机科学和人工智能实验室的成员，并领导着其中的信息安全和隐私中心。他1977年从斯坦福大学获得计算机博士学位，主要从事密码安全、计算机安全算法的研究。他和Adi Shamir和Len Adleman一起发明了RSA公钥算法，这个算法在信息安全中获得最大的突破，这一成果也使他和Shamir、Adleman一起得到2002年ACM图灵奖。他现在担任国家密码学会的负责人。\n" +
                "克利福德•斯坦（Clifford Stein）哥伦比亚大学计算机科学系和工业工程与运筹学系教授，他还是工业工程与运筹学系的系主任。在加入哥伦比亚大学大学之前，他在达特茅斯学院计算机科学系任教9年。Stein教授拥有MIT硕士和博士学位。他的研究兴趣包括：算法的设计与分析，组合优化、运筹学、网络算法、调度、算法工程和生物计算。");
        book15.setCurCost(BigDecimal.valueOf(98.00));
        book15.setPrevCost(BigDecimal.valueOf(128.00));
        bookRepository.save(book15);

        Book book16 = new Book();
        book16.setID(16);
        book16.setName("三体(1-3)(套装共3册)");
        book16.setAuthor("刘慈欣");
        book16.setISBN("7229030935");
        book16.setStock(100);
        book16.setFrontpage("http://localhost:8080/resources/11.jpg");
        book16.setCategory(cate2);
        book16.setBookDetail("从《三体》三部曲出版问世至今，刘慈欣对很多热爱这部作品的人来说，就一直是一个“神一样的存在”。这是一部被视为“中国科幻文学里程碑”式的作品，一时间在中国读者当中，风头无两。对于这部作品的讨论也开始进入学院派的范畴，但是，有一点目前是有共识的，就是他的出版商、中国最具影响力的科幻文学杂志《科幻世界》主编姚海军所说，“《三体》体现了前沿的想象力，让读者看到中国人在想象世界里到底还能走多远。”5月26日，中国教育图书进出口有限公司宣布，《三体》三部曲——《三体》《黑暗森林》《死神永生》的英文版将于2014年10月、2015年5月、2016年1月分三步在美国出版发行。这部被誉为“中国科幻文学的里程碑”之作，即将走向大洋彼岸。\n" +
                "-----上海《外滩画报社》2014年05月28日 第593期(专访《三体》作者刘慈欣：颠覆旧世界的向往)\n" +
                "\n" +
                "中国内地出了一套「奇书」，叫《三体》。对于非专业的普通读者来说，《三体》是一部让人眼界大开的「离地」体验。看完后，仰望夜空，你看到的星星变得不一样了。\n" +
                "--------香港《文汇报》2011-04-18(宇宙露出真相 人類逃往何方)\n" +
                "\n" +
                "从「童年末日」到「星际奇兵」，虽然外星智慧介入地球文明发展的故事，在科幻领域中已算「老梗」，但「三体」仍成功营造了许多「既熟悉又陌生」的科幻氛围。\n" +
                "-------杜加维(台湾)，森林学研究所毕业 曾任台大创发社干部(脸书社团 \"创发社CAIV\" 召集人 )");
        book16.setAuthorDetail("刘慈欣，中国作家富豪榜上榜作家，中国科普作家协会会员，山西省作家协会会员，中国科幻小说的最主要代表作家，被誉为中国科幻的领军人物。自上世纪九十年代开始发表科幻作品，曾于1999年至2006年连续八年获得中国科幻银河奖，作品因宏伟大气、想象绚丽而获得广泛赞誉。他的科幻小说成功地将极端的空灵和厚重的现实结合起来，同时注重表现科学的内涵和美感，兼具人文的思考与关怀，努力创造出一种具有中国特色的科幻文学样式。\n" +
                "刘慈欣，出生于1963年6月，祖籍河南，山西阳泉长大，1985年毕业于华北水利水电学院（现华北水利水电大学）水利工程系，后于山西娘子关电厂任计算机工程师。刘慈欣长期关注科幻并尝试写作，他的风格多次变换，直到90年代中期才逐渐定型，并开始赢得读者的喝彩。1999年发表第一篇作品──短篇小说《鲸歌》，同年首次以短篇小说《带上她的眼睛》获得中国科幻银河奖一等奖；2000年《流浪地球》获中国科幻银河奖特等奖。刘慈欣迄今为止最重要的作品“三体三部曲”（原名“地球往事三部曲”）更是备受读者与媒体的赞誉，被普遍认为是中国科幻文学的里程碑之作，将中国科幻推上了世界的高度。");
        book16.setCurCost(BigDecimal.valueOf(67.40));
        book16.setPrevCost(BigDecimal.valueOf(93.00));
        bookRepository.save(book16);
    }
}
