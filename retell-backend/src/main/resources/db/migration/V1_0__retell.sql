-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- 主机： 127.0.0.1
-- 生成日期： 2019-04-22 15:24:19
-- 服务器版本： 10.1.35-MariaDB
-- PHP 版本： 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 数据库： `retell`
--

-- --------------------------------------------------------

--
-- 表的结构 `book`
--

CREATE TABLE `book` (
  `ID` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `author` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `ISBN` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `stock` int(10) NOT NULL,
  `front_page` varchar(255) NOT NULL,
  `book_detail` text,
  `author_detail` text,
  `category` int(11) NOT NULL,
  `cur_cost` decimal(5,2) NOT NULL,
  `prev_cost` decimal(5,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `book`
--

INSERT INTO `book` (`ID`, `name`, `author`, `ISBN`, `stock`, `front_page`, `book_detail`, `author_detail`, `category`, `cur_cost`, `prev_cost`) VALUES
(1, '机器学习', '周志华', '123456', 99, 'http://localhost:8080/ml.jpg', 'ACM数据挖掘中国分会点评周志华教授的专著《机器学习》\\n2016-02-05 KDD China CKDD\\n南京大学周志华教授撰写的《机器学习》（清华大学出版社）上架不到一周即成为亚马逊*\\n畅销商品，各网站上现货被抢购一空，一时间“洛阳纸贵”。技术类书籍热卖到此程度，相\\n\\n当罕见。ACM数据挖掘中国分会部分专家仔细研读了这本专著，给出如下评价：\\n\\n\\n全书16章，附带相关矩阵、优化、概率知识的附录，共425页，62.6万字。中国计算机学会\\n终身成就奖得主陆汝钤院士作序，书后有作者自撰后记。该书有以下特点：\\n1. 内容系统全面。全书16章，覆盖了机器学习几乎所有的主要分支领域，覆盖面超过了该\\n领域国际著名书籍如ESL与PRML：** 部分（**-3 章）介绍机器学习的基础知识；第2 部', '周志华，南京大学计算机系教授，ACM杰出科学家，IEEE Fellow, IAPR Fellow, IET/IEE Fellow, 中国计算机学会会士。国家杰出青年科学基金获得者、长江学者特聘教授。先后担任多种SCI(E)期刊执行主编、副主编、副编辑、编委等。中国计算机学会人工智能与模式识别专业委员会主任，中国人工智能学会机器学习专业委员会主任，IEEE计算智能学会数据挖掘技术委员会副主席。', 1, '22.00', '45.00'),
(2, '算法（第4版）（图灵图书）', 'Robert Sedgewick, Kevin Wayne', '9787115293800', 100, 'http://localhost:8080/2.jpg', '《图灵程序设计丛书:算法(第4版)》编辑推荐：Sedgewick之巨著，与高德纳TAOCP一脉相承，几十年多次修订，经久不衰的畅销书，涵盖所有程序员必须掌握的50种算法。《图灵程序设计丛书:算法(第4版)》全面讲述算法和数据结构的必备知识，具有以下几大特色：\r\n算法领域的经典参考书：Sedgewick畅销著作的最新版，反映了经过几十年演化而成的算法核心知识体系。\r\n内容全面：全面论述排序、搜索、图处理和字符串处理的算法和数据结构，涵盖每位程序员应知应会的50种算法。\r\n全新修订的代码：全新的Java实现代码，采用模块化的编程风格，所有代码均可供读者使用。\r\n与实际应用相结合：在重要的科学、工程和商业应用环境下探讨算法，给出了算法的实际代码，而非同类著作常用的伪代码。\r\n富于智力趣味性：简明扼要的内容，用丰富的视觉元素展示的示例，精心设计的代码，详尽的历史和科学背景知识，各种难度的练习，这一切都将使读者手不释卷。\r\n科学的方法：用合适的数学模型精确地讨论算法性能，这些模型是在真实环境中得到验证的。\r\n与网络相结合：配套网站algs4.cs.princeton.edu提供了本书内容的摘要及相关的代码、测试数据、编程练习、教学课件等资源。', '作者：（美国）塞奇威克（Robert Sedgewick）^韦恩（Kevin Wayne） 译者：谢路云\r\n\r\n塞奇威克（Robert Sedgewick），斯坦福大学博士，导师为Donald E. Knuth，从1985年开始一直担任普林斯顿大学计算机科学系教授，曾任该系主任，也是Adobe Systems公司董事会成员，曾在Xerox PARC、国防分析研究所（institute for Defense Analyses）和法国国家信息与自动化研究所（INRIA）从事研究工作。他的研究方向包括解析组合学、数据结构和算法的分析与设计、程序可视化等。\r\n韦恩（Kevin Wayne），康奈尔大学博士，普林斯顿大学计算机科学系高级讲师，研究方向包括算法的设计、分析和实现，特别是图和离散优化。', 1, '80.60', '99.00'),
(3, '深度学习：智能时代的核心驱动力量', '谢诺夫斯基', '9787508698359, 7508698355', 100, 'http://localhost:8080/3.jpg', '编辑推荐\r\n★ 【不是所有写深度学习的书你都能读得懂。】以堪比文学书的流畅，引领你了解人工智能井喷式发展的真相。\r\n★ 【深度学习会扩大你的认知，人工智能不是生存威胁。】这本书所讲的内容，与每个人的生活息息相关。AlphaGo、自动驾驶、语音识别、智能翻译、AI医疗、图像识别……你所看到的各种形式的人工智能，背后都是深度学习在发挥作用。这本书将告诉你，深度学习有哪些神奇之处，并对你产生哪些影响。\r\n★ 【人工智能大牛作者重磅作品】世界十大AI科学家之一、美国“四院院士”（全美在世仅3位）、全球人工智能专业会议NIPS基金会主席特伦斯·谢诺夫斯基（Terrence/Terry Sejnowski）力作。\r\n★ 【AI女神、AI教父联袂推荐】谷歌前云AI负责人、斯坦福大学HAI研究院联合创始人 李飞飞、AI教父杰弗里·辛顿诚挚推荐\r\n★ 【风靡全球，多语种同步上市】风靡全球的智能时代前沿读本，全景展示深度学习的发展与应用。被翻译成多国语言，300万+用户一致好评。\r\n★ 【想了解深度学习，读这本就够了。】很多信息都在传递AI会给我们带来革命性的巨变，却只点出了表象，而这本书将从AI的源头——深度学习开始，讲述这个智能时代核心驱动力量如何一步步影响科技、商业乃至整个世界的进步。\r\n名人推荐\r\n\"特伦斯是一名杰出的神经科学家，我们于1986年共同发明了玻尔兹曼机。\r\n——AI教父 杰弗里·辛顿\r\n\r\n人工智能是科技王冠上的钻石，而深度学习代表了其中一个承上启下的重要阶段。这本书有助于在我们心目中更加清晰准确地绘制人工智能的未来图景。你可以从本书中了解到那些令人惊讶，甚至于有些担忧的科技进展，大致了解它们背后的原理。这展现了人工智能相对于人类而言的单方面优势。你也能看到许多真实事例，反映了人工智能相对于人类而言的“笨拙”。在现实中，这种“笨拙”的情况往往更加普遍。这些事例有时令人忍俊不禁，它恰恰体现了我们人类的大脑是多么精妙的设计。\r\n——微软小冰之父、微软（亚洲）互联网工程院副院长 李笛 \r\n\r\n特伦斯·谢诺夫斯基作为深度学习领域的先驱，带领该领域由理论命题走向实证科学。这是一大飞跃。\r\n——诺贝尔生理学或医学奖得主 埃里克·坎德尔\r\n\r\n作为深度学习领域的亲历者，以及深度学习灵魂人物的同行者，谢诺夫斯基分享了这一技术发展过程中的洞见和轶事。这本书记录了人工智能这场狂飙运动，字里行间都能感受到作者的兴奋和投入。\r\n——互联网之父、谷歌副总裁 文顿·瑟夫\r\n\r\n人工智能正在觉醒，世界正在被重塑。深度学习正是这一变化背后的驱动力。特伦斯·谢诺夫斯基扎根该领域研究30年，是绝对的先驱。如果你想了解人工智能，必读此书。\r\n——麻省理工学院斯隆商学院教授 埃里克·布林约尔夫松', '特伦斯·谢诺夫斯基 Terrence (Terry) Sejnowski \r\n\r\n世界十大AI科学家之一，美国四大国家学院（国家科学院、国家医学院、国家工程院、国家艺术与科学学院）在世仅3位的“四院院士”之一，全球AI专业会议NIPS基金会主席。\r\n\r\n作为神经网络的先驱，早在1986年，特伦斯就与杰弗里·辛顿共同发明了玻尔兹曼机，把神经网络带入到研究与应用的热潮，将深度学习从边缘课题变成了互联网科技公司仰赖的核心技术，实现了人工智能井喷式的发展。\r\n\r\n特伦斯现任美国索尔克生物研究所(美国生命科学领域成果最多的研究机构) 计算神经生物学实验室主任，是美国政府注资50亿美元“脑计划”项目（BRAIN，the Brain Research through Advancing Innovative Neurotechnologies）领军人物。\r\n\r\n特伦斯同时是全球最大在线学习平台Coursera很受欢迎课程《学习如何学习》（Learning how to learn）主理人，通过系统讲解大脑认知的底层知识，让学习者可以改变思维模式，提高学习的能力和效率。目前该课程学习人数已经超过了300万。', 1, '51.92', '88.00');

-- --------------------------------------------------------

--
-- 表的结构 `book_category`
--

CREATE TABLE `book_category` (
  `ID` int(11) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `book_category`
--

INSERT INTO `book_category` (`ID`, `name`) VALUES
(1, '计算机'),
(2, '小说'),
(3, '文学'),
(4, '人文社科'),
(5, '医学'),
(6, '教辅'),
(7, '艺术'),
(8, '生活'),
(9, '进口原版');

-- --------------------------------------------------------

--
-- 表的结构 `cart`
--

CREATE TABLE `cart` (
  `ID` int(11) NOT NULL,
  `userID` int(11) NOT NULL,
  `bookID` int(11) NOT NULL,
  `ammount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `cart`
--

INSERT INTO `cart` (`ID`, `userID`, `bookID`, `ammount`) VALUES
(1, 1, 1, 2),
(2, 1, 3, 3);

-- --------------------------------------------------------

--
-- 表的结构 `comment`
--

CREATE TABLE `comment` (
  `ID` int(11) NOT NULL,
  `content` text NOT NULL,
  `time` datetime NOT NULL,
  `score` int(11) NOT NULL,
  `userID` int(11) NOT NULL,
  `bookID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `comment`
--

INSERT INTO `comment` (`ID`, `content`, `time`, `score`, `userID`, `bookID`) VALUES
(1, '我很喜欢这本书啊', '2019-04-22 06:00:00', 5, 1, 1);

-- --------------------------------------------------------

--
-- 表的结构 `deal`
--

CREATE TABLE `deal` (
  `ID` int(11) NOT NULL,
  `userID` int(11) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `address` varchar(255) NOT NULL,
  `time` datetime NOT NULL,
  `total_price` decimal(5,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `deal`
--

INSERT INTO `deal` (`ID`, `userID`, `phone`, `address`, `time`, `total_price`) VALUES
(1, 1, '18217508975', '上海市闵行区东川路800号交通大学东16', '2019-04-23 06:00:00', '80.00');

-- --------------------------------------------------------

--
-- 表的结构 `deal_book`
--

CREATE TABLE `deal_book` (
  `ID` int(11) NOT NULL,
  `bookID` int(11) NOT NULL,
  `ammount` int(11) NOT NULL,
  `dealID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `deal_book`
--

INSERT INTO `deal_book` (`ID`, `bookID`, `ammont`, `dealID`) VALUES
(1, 1, 1, 1),
(2, 2, 1, 1);

-- --------------------------------------------------------

--
-- 表的结构 `user`
--

CREATE TABLE `user` (
  `ID` int(11) NOT NULL,
  `username` varchar(50) CHARACTER SET utf8mb4 NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) CHARACTER SET utf8mb4 NOT NULL,
  `role` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `user`
--

INSERT INTO `user` (`ID`, `username`, `password`, `email`, `role`) VALUES
(1, 'user', '123456', '1035254583@qq.com', 1);

--
-- 转储表的索引
--

--
-- 表的索引 `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`ID`);

--
-- 表的索引 `book_category`
--
ALTER TABLE `book_category`
  ADD PRIMARY KEY (`ID`);

--
-- 表的索引 `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`ID`);

--
-- 表的索引 `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`ID`);

--
-- 表的索引 `deal`
--
ALTER TABLE `deal`
  ADD PRIMARY KEY (`ID`);

--
-- 表的索引 `deal_book`
--
ALTER TABLE `deal_book`
  ADD PRIMARY KEY (`ID`);

--
-- 表的索引 `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `username` (`username`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `book`
--
ALTER TABLE `book`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- 使用表AUTO_INCREMENT `book_category`
--
ALTER TABLE `book_category`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- 使用表AUTO_INCREMENT `cart`
--
ALTER TABLE `cart`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- 使用表AUTO_INCREMENT `comment`
--
ALTER TABLE `comment`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- 使用表AUTO_INCREMENT `deal`
--
ALTER TABLE `deal`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- 使用表AUTO_INCREMENT `deal_book`
--
ALTER TABLE `deal_book`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- 使用表AUTO_INCREMENT `user`
--
ALTER TABLE `user`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
