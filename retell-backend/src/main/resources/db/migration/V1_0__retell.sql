-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- 主机： 127.0.0.1
-- 生成日期： 2019-05-12 03:28:23
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
-- 表的结构 `ad_carousel`
--

CREATE TABLE `ad_carousel` (
  `ID` int(11) NOT NULL,
  `content` int(11) NOT NULL,
  `img` blob NOT NULL,
  `url` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
(1, '机器学习', '周志华', '123456', 98, 'http://localhost:8080/resources/ml.jpg', 'ACM数据挖掘中国分会点评周志华教授的专著《机器学习》\\n2016-02-05 KDD China CKDD\\n南京大学周志华教授撰写的《机器学习》（清华大学出版社）上架不到一周即成为亚马逊*\\n畅销商品，各网站上现货被抢购一空，一时间“洛阳纸贵”。技术类书籍热卖到此程度，相\\n\\n当罕见。ACM数据挖掘中国分会部分专家仔细研读了这本专著，给出如下评价：\\n\\n\\n全书16章，附带相关矩阵、优化、概率知识的附录，共425页，62.6万字。中国计算机学会\\n终身成就奖得主陆汝钤院士作序，书后有作者自撰后记。该书有以下特点：\\n1. 内容系统全面。全书16章，覆盖了机器学习几乎所有的主要分支领域，覆盖面超过了该\\n领域国际著名书籍如ESL与PRML：** 部分（**-3 章）介绍机器学习的基础知识；第2 部', '周志华，南京大学计算机系教授，ACM杰出科学家，IEEE Fellow, IAPR Fellow, IET/IEE Fellow, 中国计算机学会会士。国家杰出青年科学基金获得者、长江学者特聘教授。先后担任多种SCI(E)期刊执行主编、副主编、副编辑、编委等。中国计算机学会人工智能与模式识别专业委员会主任，中国人工智能学会机器学习专业委员会主任，IEEE计算智能学会数据挖掘技术委员会副主席。', 1, '22.00', '45.00'),
(2, '算法（第4版）（图灵图书）', 'Robert Sedgewick, Kevin Wayne', '9787115293800', 98, 'http://localhost:8080/resources/2.jpg', '《图灵程序设计丛书:算法(第4版)》编辑推荐：Sedgewick之巨著，与高德纳TAOCP一脉相承，几十年多次修订，经久不衰的畅销书，涵盖所有程序员必须掌握的50种算法。《图灵程序设计丛书:算法(第4版)》全面讲述算法和数据结构的必备知识，具有以下几大特色：\r\n算法领域的经典参考书：Sedgewick畅销著作的最新版，反映了经过几十年演化而成的算法核心知识体系。\r\n内容全面：全面论述排序、搜索、图处理和字符串处理的算法和数据结构，涵盖每位程序员应知应会的50种算法。\r\n全新修订的代码：全新的Java实现代码，采用模块化的编程风格，所有代码均可供读者使用。\r\n与实际应用相结合：在重要的科学、工程和商业应用环境下探讨算法，给出了算法的实际代码，而非同类著作常用的伪代码。\r\n富于智力趣味性：简明扼要的内容，用丰富的视觉元素展示的示例，精心设计的代码，详尽的历史和科学背景知识，各种难度的练习，这一切都将使读者手不释卷。\r\n科学的方法：用合适的数学模型精确地讨论算法性能，这些模型是在真实环境中得到验证的。\r\n与网络相结合：配套网站algs4.cs.princeton.edu提供了本书内容的摘要及相关的代码、测试数据、编程练习、教学课件等资源。', '作者：（美国）塞奇威克（Robert Sedgewick）^韦恩（Kevin Wayne） 译者：谢路云\r\n\r\n塞奇威克（Robert Sedgewick），斯坦福大学博士，导师为Donald E. Knuth，从1985年开始一直担任普林斯顿大学计算机科学系教授，曾任该系主任，也是Adobe Systems公司董事会成员，曾在Xerox PARC、国防分析研究所（institute for Defense Analyses）和法国国家信息与自动化研究所（INRIA）从事研究工作。他的研究方向包括解析组合学、数据结构和算法的分析与设计、程序可视化等。\r\n韦恩（Kevin Wayne），康奈尔大学博士，普林斯顿大学计算机科学系高级讲师，研究方向包括算法的设计、分析和实现，特别是图和离散优化。', 1, '80.60', '99.00'),
(3, '深度学习：智能时代的核心驱动力量', '谢诺夫斯基', '9787508698359', 83, 'http://localhost:8080/resources/3.jpg', '编辑推荐\r\n★ 【不是所有写深度学习的书你都能读得懂。】以堪比文学书的流畅，引领你了解人工智能井喷式发展的真相。\r\n★ 【深度学习会扩大你的认知，人工智能不是生存威胁。】这本书所讲的内容，与每个人的生活息息相关。AlphaGo、自动驾驶、语音识别、智能翻译、AI医疗、图像识别……你所看到的各种形式的人工智能，背后都是深度学习在发挥作用。这本书将告诉你，深度学习有哪些神奇之处，并对你产生哪些影响。\r\n★ 【人工智能大牛作者重磅作品】世界十大AI科学家之一、美国“四院院士”（全美在世仅3位）、全球人工智能专业会议NIPS基金会主席特伦斯·谢诺夫斯基（Terrence/Terry Sejnowski）力作。\r\n★ 【AI女神、AI教父联袂推荐】谷歌前云AI负责人、斯坦福大学HAI研究院联合创始人 李飞飞、AI教父杰弗里·辛顿诚挚推荐\r\n★ 【风靡全球，多语种同步上市】风靡全球的智能时代前沿读本，全景展示深度学习的发展与应用。被翻译成多国语言，300万+用户一致好评。\r\n★ 【想了解深度学习，读这本就够了。】很多信息都在传递AI会给我们带来革命性的巨变，却只点出了表象，而这本书将从AI的源头——深度学习开始，讲述这个智能时代核心驱动力量如何一步步影响科技、商业乃至整个世界的进步。\r\n名人推荐\r\n\"特伦斯是一名杰出的神经科学家，我们于1986年共同发明了玻尔兹曼机。\r\n——AI教父 杰弗里·辛顿\r\n\r\n人工智能是科技王冠上的钻石，而深度学习代表了其中一个承上启下的重要阶段。这本书有助于在我们心目中更加清晰准确地绘制人工智能的未来图景。你可以从本书中了解到那些令人惊讶，甚至于有些担忧的科技进展，大致了解它们背后的原理。这展现了人工智能相对于人类而言的单方面优势。你也能看到许多真实事例，反映了人工智能相对于人类而言的“笨拙”。在现实中，这种“笨拙”的情况往往更加普遍。这些事例有时令人忍俊不禁，它恰恰体现了我们人类的大脑是多么精妙的设计。\r\n——微软小冰之父、微软（亚洲）互联网工程院副院长 李笛 \r\n\r\n特伦斯·谢诺夫斯基作为深度学习领域的先驱，带领该领域由理论命题走向实证科学。这是一大飞跃。\r\n——诺贝尔生理学或医学奖得主 埃里克·坎德尔\r\n\r\n作为深度学习领域的亲历者，以及深度学习灵魂人物的同行者，谢诺夫斯基分享了这一技术发展过程中的洞见和轶事。这本书记录了人工智能这场狂飙运动，字里行间都能感受到作者的兴奋和投入。\r\n——互联网之父、谷歌副总裁 文顿·瑟夫\r\n\r\n人工智能正在觉醒，世界正在被重塑。深度学习正是这一变化背后的驱动力。特伦斯·谢诺夫斯基扎根该领域研究30年，是绝对的先驱。如果你想了解人工智能，必读此书。\r\n——麻省理工学院斯隆商学院教授 埃里克·布林约尔夫松', '特伦斯·谢诺夫斯基 Terrence (Terry) Sejnowski \r\n\r\n世界十大AI科学家之一，美国四大国家学院（国家科学院、国家医学院、国家工程院、国家艺术与科学学院）在世仅3位的“四院院士”之一，全球AI专业会议NIPS基金会主席。\r\n\r\n作为神经网络的先驱，早在1986年，特伦斯就与杰弗里·辛顿共同发明了玻尔兹曼机，把神经网络带入到研究与应用的热潮，将深度学习从边缘课题变成了互联网科技公司仰赖的核心技术，实现了人工智能井喷式的发展。\r\n\r\n特伦斯现任美国索尔克生物研究所(美国生命科学领域成果最多的研究机构) 计算神经生物学实验室主任，是美国政府注资50亿美元“脑计划”项目（BRAIN，the Brain Research through Advancing Innovative Neurotechnologies）领军人物。\r\n\r\n特伦斯同时是全球最大在线学习平台Coursera很受欢迎课程《学习如何学习》（Learning how to learn）主理人，通过系统讲解大脑认知的底层知识，让学习者可以改变思维模式，提高学习的能力和效率。目前该课程学习人数已经超过了300万。', 1, '51.92', '88.00'),
(4, '人间失格', '太宰治', '7505738143', 88, 'http://localhost:8080/resources/10.jpg', '·日本“无赖派”文学大师太宰治完整代表作集结，一部纯粹的“私小说”，太宰治的灵魂之书\r\n\r\n·太宰治是日本文学史上一个备受争议的作家，他39岁便自杀身亡，一生命运多舛，良作颇多，《人间失格》是他人生中的收官之作，很具有研究价值。\r\n\r\n·五次自杀，天鹅绝唱，纤细的自传体中透露出顶峰的颓废，毁灭式的绝笔之作。', '太宰治（1909-1948），本名津岛修治，日本无赖派文学大师，1933年开始用太宰治为笔名写作他五次自杀未遂，于1948年，在《人间失格》发表后，和女读者于玉川上水道投水自尽。太宰治在短暂的写作生涯中创作了三十多部小说，早期包括《晚年》《虚构的彷徨》《二十世纪旗手》等深受注目，另有《满愿》《越级诉讼》等多部名作。为了生活，他曾以“黑木舜平”的笔名写了心理悬疑小说《断崖的错觉》，但太宰本身以此作品为耻。在他的作品中，中篇《斜阳》《人间失格》堪称日本战后文学的金字塔之巅。', 2, '18.88', '32.00'),
(5, '局外人', '加缪', '755942743X', 50, 'http://localhost:8080/resources/xx.jpg', '（1）青年法语译者全新译本，展现《局外人》语言魅力。（2）这一次终于读懂了《局外人》——法国索邦大学文学博士原创万字导读，独特角度讲解《局外人》。（3）韩国知名设计师为《局外人》情节原创彩插，中文版授权。（4）收录1956年美国版《局外人》加缪亲笔序言，收录1957年加缪在诺贝尔颁奖酒会上的演讲词，收录加缪珍贵照片资料。（5）在人类文学史上，诺贝尔文学奖得主加缪的荒诞主义代表作《局外人》，以其独特的视角展示世界的荒诞性，成为二十世纪整个西方文坛具有划时代意义的伟大作品。', '阿尔贝·加缪(1913-1960）Albert Camus\n“存在主义”文学大师\n“荒诞哲学”的代表作家\n阿尔贝·加缪，法国著名作家、哲学家、文学理论家。1942年，他凭借《局外人》一举成名。1957年，因为“他的重要文学创作以明彻的认真态度阐明了我们这个时代人类良知的问题”，加缪获得了诺贝尔文学奖。1960年，他在前往巴黎的途中遭遇车祸身亡，年仅47岁。\n加缪的作品始终从人的现实生存困境出发，揭示了世界的荒诞性。他主张人类要直面荒诞，并且在荒诞中奋起反抗，坚持真理和正义。这一思想使他成为二战后欧洲乃至全世界几代青年的“精神导师”。', 3, '26.55', '45.00'),
(6, 'C++ Primer Plus中文版(第6版)', '蒂芬•普拉达 (Stephen Prata)', '9787115279460', 99, 'http://localhost:8080/resources/6.jpg', '一本经久不衰的C++畅销经典教程；一本支持C++11新标准的程序设计图书。 \r\n　　它被誉为“开发人员学习C++的教程，没有之一”！ Amazon网站“Language”类销售排名第三的超级畅销书，之前版本在美国销售超10万！ \r\n　　《C++ Primer Plus(第6版)中文版》可以说是一本面向从未学习过C语言甚到是从未学习过编程的人的入门书籍，它的一章从基础内容讲起，先介绍了传统编程的规则，后面才着重讲解有关面向对象——C++的精髓之一——的有关内容。整个书的结构安排较为合理，难度爬升较慢。 \r\n　　如果你是一个从未学过C语言（或者压根没学会C）的读者，那么，我相信这本书更适合你。\r\n\r\n媒体推荐', 'Stephen Prata，在美国加州肯特菲尔得的马林学院教授天文、物理和计算机科学。他毕业于加州理工学院，在美国加州大学伯克利分校获得博士学位。他单独或与他人合作编写的编程图书有十多本，其中《New C Primer Plus》获得了计算机出版联合会1990年度“How-to”计算机图书奖，《C++ Primer Plus》获得了计算机出版联合会1991年度“How-to”计算机图书奖提名。', 1, '81.40', '99.00'),
(7, 'Effective C++:改善程序与设计的55个具体做法(第3版)(中文版)', '梅耶(Scott Meyers),侯捷', '7121123320', 100, 'http://localhost:8080/resources/7.jpg', '《Effective C++:改善程序与设计的55个具体做法(第3版)(中文版)(双色)》前两个版本抓住了全世界无数程序员的目光。原因十分明显：Scott Meyers极富实践意义的C++研讨方式，描述出专家用以产出干净、正确、高效代码的经验法则和行事法则——也就是他们几乎总是做或不做的某些事。\r\n《Effective C++:改善程序与设计的55个具体做法(第3版)(中文版)(双色)》一共组织55个准则，每一条准则描述一个编写出更好的C++的方式、每一个条款的背后都有具体范例支撑。第三版有一半以上的篇幅是崭新内容，包括讨沦资源管理和模块（templates）运用的两个新章。为反映出现代设计考虑，对第二版论题做了广泛的修订，包括异常（exceptions）、没汁模式（design patterns）和多线程（multithreading）。\r\n高效的Classes、functions、templates和inheritance hierarchies（继承体系）方面的专家级指导。\r\n崭新的“TR1”标准程序库功能应用，以及与既有标准程序库组件的比较。\r\n洞察C++和其他语言（例如Java、C＃、C）之间的不同。此举有助于那些来自其他语言阵营的开发人员消化吸收C++式的各种解法。', '作者：（美国）梅耶(Scott Meyers) 译者：侯捷\r\n\r\n梅耶（Scott Meyers），是全世界最知名的C++软件开发专家之一。他是畅销书《Effective C++》系列（Effective C++，More Effective C++，Effective STL）的作者，又是创新产品《Effective C++CD》的设计者和作者，也是Addison-wesley的“Effective Software Development Series”顾问编辑，以及《Software Development》杂志咨询板成员。他也为若干新公司的技术咨询板提供服务。Meyers于1993年自Brown大学获得计算机博土学位。\r\n侯捷，是计算机技术书籍的作家、泽者、书评人。著有《深入浅出MFC》、《多犁与虚拟》、《STL源码剖析》、《无责任书评》三卷，泽有众多脍炙人口的高阶技术书籍，包括Meyers所著的“Effective C++”系列。侯捷兼任教职于元智大学、同济大学、南京大学。', 1, '53.70', '65.00'),
(8, '微服务设计 (图灵程序设计丛书)', '纽曼(Sam Newman)', 'B01ER75V6O', 100, 'http://localhost:8080/resources/8.jpg', '本书全面介绍了微服务的建模、集成、测试、部署和监控，通过一个虚构的公司讲解了如何建立微服务架构。主要内容包括认识微服务在保证系统设计与组织目标统一上的重要性，学会把服务集成到已有系统中，采用递增手段拆分单块大型应用，通过持续集成部署微服务，等等。 ', NULL, 1, '55.20', '65.00'),
(9, '算法导论(原书第3版)', 'Thomas H.Cormen, Charles E.Leiserson, Ronald L.Rivest, Clifford Stein', '9787111407010', 100, 'http://localhost:8080/resources/9.jpg', '鉴于数据量的爆炸性增长，和计算应用的多样性，现在比以往更需要有效算法。这本书条理清晰，是一本非常好的算法设计与分析方面的导论性书籍。每章前半部分介绍了讲授和学习算法的有效方法，后半部分为更专业的读者和求知欲强的学生提供了更引人入胜的资料来讨论这个迷人领域的各种可能性和挑战。\r\n——Shang-Hua Teng（腾尚华），南加州大学维特比工学院计算机系Seeley G. Mudd 教授\r\n本书是算法领域的一部经典著作，书中系统、全面地介绍了现代算法：从最快算法和数据结构到用于看似难以解决问题的多项式时间算法；从图论中的经典算法到用于字符匹配、计算集合和数论的特殊算法。本书第3版尤其增加了两章专门讨论van Emde Boas树（最有用的数据结构之一）和多线程算法（日益重要的一个主题）。\r\n——Daniel Spielman，耶鲁大学计算机科学和应用数学Henry Ford II教授\r\n作为一个在算法领域有着近30年教育和研究经验的教育者和研究人员，我可以清楚明白地说这本书是我所见到的该领域最好的教材。它对算法给出了清晰透彻、百科全书式的阐述。我们将继续使用这本书的新版作为研究生和本科生的教材和可以信赖的研究参考书。\r\n——Gabriel Robins，弗吉尼亚大学工程和应用科学学院计算机科学系教授', '作者：（美国）托马斯•科尔曼（Thomas H.Cormen） （美国）查尔斯•雷瑟尔森（Charles E.Leiserson） （美国）罗纳德•李维斯特（Ronald L.Rivest） （美国）克利福德•斯坦（Clifford Stein） 译者：王刚 邹恒明 殷建平 王宏志 等\r\n\r\n托马斯•科尔曼（Thomas H. Cormen）达特茅斯学院计算机科学系教授、系主任。目前的研究兴趣包括：算法工程、并行计算、具有高延迟的加速计算。他分别于1993年、1986年获得麻省理工学院电子工程和计算机科学博士、硕士学位，师从Charles E. Leiserson教授。由于他在计算机教育领域的突出贡献，Cormen教授荣获2009年ACM杰出教员奖。\r\n查尔斯•雷瑟尔森（Charles E. Leiserson）麻省理工学院计算机科学与电气工程系教授，Margaret MacVicar Faculty Fellow。他目前主持MIT超级计算技术研究组，并是MIT计算机科学和人工智能实验室计算理论研究组的成员。他的研究兴趣集中在并行和分布式计算的理论原理，尤其是与工程现实相关的技术研究。Leiserson教授拥有卡内基•梅隆大学计算机科学博士学位，还是ACM、IEEE和SIAM的会士。\r\n罗纳德•李维斯特（Ronald L. Rivest）现任麻省理工学院电子工程和计算机科学系安德鲁与厄纳•维特尔比（Andrew and Erna Viterbi）教授。他是MIT计算机科学和人工智能实验室的成员，并领导着其中的信息安全和隐私中心。他1977年从斯坦福大学获得计算机博士学位，主要从事密码安全、计算机安全算法的研究。他和Adi Shamir和Len Adleman一起发明了RSA公钥算法，这个算法在信息安全中获得最大的突破，这一成果也使他和Shamir、Adleman一起得到2002年ACM图灵奖。他现在担任国家密码学会的负责人。\r\n克利福德•斯坦（Clifford Stein）哥伦比亚大学计算机科学系和工业工程与运筹学系教授，他还是工业工程与运筹学系的系主任。在加入哥伦比亚大学大学之前，他在达特茅斯学院计算机科学系任教9年。Stein教授拥有MIT硕士和博士学位。他的研究兴趣包括：算法的设计与分析，组合优化、运筹学、网络算法、调度、算法工程和生物计算。', 1, '98.00', '128.00'),
(10, '三体(1-3)(套装共3册)', '刘慈欣', '7229030935', 100, 'http://localhost:8080/resources/11.jpg', '从《三体》三部曲出版问世至今，刘慈欣对很多热爱这部作品的人来说，就一直是一个“神一样的存在”。这是一部被视为“中国科幻文学里程碑”式的作品，一时间在中国读者当中，风头无两。对于这部作品的讨论也开始进入学院派的范畴，但是，有一点目前是有共识的，就是他的出版商、中国最具影响力的科幻文学杂志《科幻世界》主编姚海军所说，“《三体》体现了前沿的想象力，让读者看到中国人在想象世界里到底还能走多远。”5月26日，中国教育图书进出口有限公司宣布，《三体》三部曲——《三体》《黑暗森林》《死神永生》的英文版将于2014年10月、2015年5月、2016年1月分三步在美国出版发行。这部被誉为“中国科幻文学的里程碑”之作，即将走向大洋彼岸。\r\n-----上海《外滩画报社》2014年05月28日 第593期(专访《三体》作者刘慈欣：颠覆旧世界的向往)\r\n\r\n中国内地出了一套「奇书」，叫《三体》。对于非专业的普通读者来说，《三体》是一部让人眼界大开的「离地」体验。看完后，仰望夜空，你看到的星星变得不一样了。\r\n--------香港《文汇报》2011-04-18(宇宙露出真相 人類逃往何方)\r\n\r\n从「童年末日」到「星际奇兵」，虽然外星智慧介入地球文明发展的故事，在科幻领域中已算「老梗」，但「三体」仍成功营造了许多「既熟悉又陌生」的科幻氛围。\r\n-------杜加维(台湾)，森林学研究所毕业 曾任台大创发社干部(脸书社团 \"创发社CAIV\" 召集人 )', '刘慈欣，中国作家富豪榜上榜作家，中国科普作家协会会员，山西省作家协会会员，中国科幻小说的最主要代表作家，被誉为中国科幻的领军人物。自上世纪九十年代开始发表科幻作品，曾于1999年至2006年连续八年获得中国科幻银河奖，作品因宏伟大气、想象绚丽而获得广泛赞誉。他的科幻小说成功地将极端的空灵和厚重的现实结合起来，同时注重表现科学的内涵和美感，兼具人文的思考与关怀，努力创造出一种具有中国特色的科幻文学样式。\r\n刘慈欣，出生于1963年6月，祖籍河南，山西阳泉长大，1985年毕业于华北水利水电学院（现华北水利水电大学）水利工程系，后于山西娘子关电厂任计算机工程师。刘慈欣长期关注科幻并尝试写作，他的风格多次变换，直到90年代中期才逐渐定型，并开始赢得读者的喝彩。1999年发表第一篇作品──短篇小说《鲸歌》，同年首次以短篇小说《带上她的眼睛》获得中国科幻银河奖一等奖；2000年《流浪地球》获中国科幻银河奖特等奖。刘慈欣迄今为止最重要的作品“三体三部曲”（原名“地球往事三部曲”）更是备受读者与媒体的赞誉，被普遍认为是中国科幻文学的里程碑之作，将中国科幻推上了世界的高度。', 2, '67.40', '93.00'),
(11, '月亮和六便士(译文经典)', '毛姆', '9787532749003', 100, 'http://localhost:8080/resources/12.jpg', '译文经典:月亮和六便士》是毛姆的三大长篇力作之一，完成于1919年。毛姆，一个出生于法国的英国人，他是以戏剧成名的小说家，也是一个拥有博士学位的骑士，他在20世纪初，风靡了整个世纪和世界。他的这部小说问世后，以情节入胜、文字深刻在文坛轰动一时，人们争相传看。在这部小说里，毛姆用叙述手法，借“我”之口，叙述了整个故事，有人认为这篇小说的原型是法国印象派画家高更，这更增加了它的传奇色彩，受到了全世界读者的关注。 \r\n书中讲述了主人公原是位证券经纪人，人届中年后突然响应内心的呼唤，合弃一切到南太平洋的塔希提岛与土著人一起生活，获得灵感，创作出许多艺术杰作。毛姆在小说中深入探讨了生活和艺术两者的矛盾和相互作用。', '威廉•萨默赛特•毛姆(WilliamSomersetMaugham，1874-1965)，英国著名小说家和戏剧家。他出生于巴黎，父母早丧，回英国叔父家寄居，并在英国受教育。在大学他虽然攻读医学，但对文学兴趣颇浓。第一部长篇小说《兰贝斯的丽莎》(1897)就是根据他做见习医生期间在伦敦贫民区所见所闻写成的。他从此走上文学道路，并赴世界各地旅行、搜集素材。毛姆最初以戏剧家闻名，自二十世纪初约三十年间，共创作了近三十部剧作。早在一九O八年，他的四部戏剧在伦敦四座剧院同时上演，毛姆之名即已红极一时，但他的主要文学成就却在小说创作上。带有自传性质的《人性的枷锁》(1915)、追述英国一位文坛巨匠往事的《寻欢作乐》(1930)以及这部以一位英国画家为题材的《月亮与六便士》(1919)，都是脍炙人口的作品。毛姆的几部重要著作及近百篇短篇小说大都发表于二三十年代，但直到他已达七十高龄，仍写出轰动_\'时的畅销小说《刀锋》(1944)。毛姆是英国现代文学史上一位创作力旺盛的多产作家。\r\n毛姆具有敏锐的观察力，善于剖析人的内心世界。他的笔锋像一把解剖刀，能够挖掘出隐藏在人们心底深处的思想活动。他对待自己笔下人物常采取一种医师、“临床”的冷静态度，既不多作说教，也很少指出伦理是非，一切留给读者自己判断。他是一位伟大的旅行家，一个“世界公民”(Weltburger)；他的小说多以异国为背景，富于异乡情调。他是一个说故事的大师，叙述故事引人入胜。他写了不少貌似离奇的故事，这与他对人性不可捉摸的看法是一致的。事物的发展似在情理外，又在情理中；结尾有时一反常情，给人以惊奇而又回味无穷的感觉。他的作品结构严谨，剪裁得体，就是人物繁多，枝节蔓延的长篇也层次分明、井然有序。', 2, '27.00', '36.00'),
(12, '山月记', '中岛敦', '7551819258', 100, 'http://localhost:8080/resources/13.jpg', '* 川端康成力荐的天才小说家！\r\n*《山月记》战后常年入选日本高中国语教科书，成就中岛敦“国民作家”美誉。\r\n* 他创造了如梦似幻，亦庄亦谐的古典世界，被誉为日本虚无主义文学的开端，有“小芥川”之称。\r\n* 在自傲与自卑之间无所逃遁的李征，不停追问生命意义的沙僧悟净，将自己流放于南洋的史蒂文森……\r\n* 也许，你可以从他们身上看到自己的影子。而这本书会告诉你，唯有行动可以抵抗虚无。\r\n* 收录十篇代表作，附录中岛敦汉诗及年谱。\r\n* 鬼才漫画家撒旦君倾情绘制多幅插画，完美再现古典诡谲的世界。\r\n* 裸背线装，内文选用进口瑞典轻型纸。版式疏朗复古，装帧精致典雅。\r\n\r\n在古典与现代之间，读懂《山月记》，就读懂自己内心的焦虑。', '中岛敦(1909-1942)\r\n出生于日本东京，祖父及父亲都是汉儒学者。1933年3月毕业于东京帝国大学文学部，曾在横滨女子高等学校任教，后任职南洋厅。1942年12月因哮喘病发作而去世。《山月记》在战后被选入日本高中国语教科书，广为流传。《光·风·梦》为芥川文学奖候选作品。由筑摩书房出版的《中岛敦全集》获日本“每日出版文化奖”', 2, '38.30', '45.00'),
(13, '平凡的世界：全三册', '路遥', '7530216783', 100, 'http://localhost:8080/resources/14.jpg', '路遥获得了这个世界里数以亿计的普通人的尊敬和崇拜，他沟通了这个世界的人们和地球人类的情感。\r\n——陈忠实\r\n他是一个优秀的作家，他是一个出色的政治家，他是一个气势磅礴的人。但他是夸父，倒在干渴的路上。他的文学就像火一样燃出炙人的灿烂的光焰。\r\n——贾平凹\r\n对我影响极大的人是路遥。是路遥的作品改变了我，让我意识到不放弃总有机会，否则我现在还在蹬三轮车呢。\r\n——马云\r\n作家路遥用毕生心血写就的《平凡的世界》，展示了一幅宏大的普通人在时代大变革中所走过的既平凡又壮美的人生画卷。人生的奋斗，理想的追求，在不同的时代都是相似的。希望你们在来到清华园之前，利用假期认真阅读这本书。\r\n——清华大学校长邱勇', '路遥（1949-1992）原名王卫国，1949年12月3日生于陕西榆林市清涧县一个贫困的农民家庭，7岁时因为家里困难被过继给延川县农村的伯父。曾在延川县立中学学习，1969年回乡务农。这段时间里他做过许多临时性的工作，并在农村一小学中教过一年书。1973年进入延安大学中文系学习。', 2, '83.10', '108.00'),
(14, '百年孤独', '加西亚.马尔克斯', '7544291170', 100, 'http://localhost:8080/resources/15.jpg', '我读《百年孤独》这本书第一个感觉是“震撼”。原来小说可以这样写。紧接着感觉到遗憾，我为什么早不知道小说可以这样写呢？二十多年来我始终在跟马尔克斯搏斗。这样的作家，我们既恨又爱，爱是因为打开我们头脑很多的禁锢，恨他是因为他的吸引力太强大了。——2012年诺贝尔文学奖得主莫言\r\n\r\n《百年孤独》我读了三遍，现在我的孩子也已经读完《百年孤独》，他在英国跟我一块在火车上读的，一边读还一段一段念给我听。这是一本天才之作。——余华\r\n\r\n我对《百年孤独》有非常真实的、崇敬的感觉。这样的作品会不停地卖，一代一代的人都会读，是长销书，当年文学青年几乎人手一本。——苏童\r\n\r\n《百年孤独》乃是过去五十年来所有语言中zui伟大的杰作。——萨尔曼·拉什迪\r\n\r\n一部惟一的美洲《圣经》。——卡洛斯·富恩特斯\r\n\r\n《百年孤独》在马尔克斯构建的虚拟世界中达到了顶峰。这部小说整合并且超越了他以前的所有虚构，从而缔造了一个极其丰饶的双重世界。它穷尽了世界，同时自我穷尽。——巴尔加斯·略萨\r\n\r\n加西亚·马尔克斯是所有语言中zui伟大的作家。——比尔·克林顿\r\n\r\n他是个强有力的作家，有着丰富的想象。他继承了欧洲政治小说的伟大传统，其结果是历史剧与个人戏剧合二为一。——欧文·肖\r\n\r\n加西亚·马尔克斯是诺贝尔文学奖得主中惟一没有争议的一位。——韩素音\r\n\r\n媒体推荐\r\n《创世记》之后，首部值得全人类阅读的文学巨著。——《纽约时报》\r\n\r\n加西亚·马尔克斯以小说作品创建了一个自己的世界，一个浓缩的宇宙，其中喧嚣纷乱却又生动可信的现实，映射了一片大陆及其人民的富足与贫困。——诺贝尔文学奖颁奖辞', '加西亚·马尔克斯（GarcíaMárquez），哥伦比亚作家，魔幻现实主义文学代表人物。1927年出生于哥伦比亚马格达莱纳海滨小镇阿拉卡塔卡。童年与外祖父母一起生活。1936年随父母迁居苏克雷。1947年考入波哥大国立大学。1948年进入报界。五十年代开始出版文学作品。六十年代初移居墨西哥。1967年出版《百年孤独》。1982年获诺贝尔文学奖。其作品被认为是“20世纪的文学标杆”，影响滋养了几代中文作家。\r\n\r\n主要作品有长篇小说《百年孤独》《霍乱时期的爱情》，中篇小说《没有人给他写信的上校》《一桩事先张扬的凶杀案》，短篇小说集《世上最美的溺水者》《礼拜二午睡时刻》，自传《活着为了讲述》，非虚构文学作品《一个海难幸存者的故事》等。\r\n\r\n作为魔幻现实主义文学的代表作，《百年孤独》酝酿达十数年之久，1965年开始创作，1967年出版，在拉丁美洲乃至全球引起巨大轰动，被誉为“再现拉丁美洲社会历史图景的鸿篇巨著”、“值得全人类阅读的文学巨著”。', 2, '41.30', '55.00'),
(15, '慢煮生活', '汪曾祺', '7559407250', 100, 'http://localhost:8080/resources/16.jpg', '汪曾祺逝世20周年 精装纪念散文集。\r\n\r\n完整收录《五味》《昆明的雨》《人间草木》《星斗其文，赤子其人》等经典名篇，同时新增《猫》《一技》《名优逸事》《和尚》《一辈古人》等罕见篇目，内容涵盖花鸟虫鱼、乡情民俗、凡人小事、旅途见闻。\r\n\r\n全新修订，环保护眼纸，完美精装，适合珍藏。\r\n\r\n特别收录汪曾祺本人的书画作品，四色印刷，妙趣横生。\r\n\r\n汪曾祺留给世间的不仅是文字，更是一种生活态度——不管在什么环境下，永远不消沉沮丧，无机心，少俗虑，兴致盎然地生活。\r\n\r\n“我们有过各种创伤，但我们今天应该快活。”\r\n\r\n献给繁忙都市中渴望诗意栖居的你。', '汪曾祺（1920-1997）\r\n不管在什么环境下，永远不消沉沮丧，无机心，少俗虑，这就是汪曾祺。\r\n中国当代作家、散文家、戏剧家，京派作家的代表人物。师从沈从文。\r\n“我曾戏称自己是一个‘中国式的抒情人道主义者’，大致差不离。”', 3, '33.88', '49.80'),
(16, '碗净福至', '蔡澜', '7570207726', 99, 'http://localhost:8080/resources/17.jpg', '★1.汪涵推崇，《风味人间》《舌尖上的中国》总顾问蔡澜2019开年新作\r\n收录《开讲啦》《鲁豫有约》、公众号“蔡澜的花花世界”等全新热门文字，以潇洒幽默之笔，写美食风味，记风物人情，述生活眷念。\r\n★2.十点读书、今日头条、金庸、陈晓卿、谢霆锋、沈宏非诚心推崇\r\n黄霑、倪匡、亦舒、鲁豫、《三联生活周刊》、二更视频、《开讲啦》《看点》《深圳卫视》《新周刊》《南方人物周刊》等倾情推荐。\r\n★3.雅致装帧，特殊工艺，特种纸张，内外双封\r\n封面选用特种纸，采用精致的特殊工艺，为读者呈现蔡澜随笔集更精美的阅读版本。\r\n★4.随书附赠蔡澜先生书法作品特等宣纸条幅\r\n特选蔡澜先生行草展书法作品一幅制成720*265宣纸条幅，此次展览的书法作品大部分已经被拍，此书法作品真迹所做条幅极具收藏价值。', '蔡澜：会生活 有趣味 真洒脱\r\n食神\r\n《风味人间》《舌尖上的中国》总顾问；联手深圳卫视，打造了美食王牌节目《蔡澜食尚》，并担任世界华人健康饮食协会荣誉主席。\r\n才子\r\n与金庸、黄霑、倪匡并称为“香港四大才子”。专栏作家，邵氏、嘉禾等公司电影监制、节目主持人，书法、篆刻、绘画样样皆通，目前已出版作品超过200本。\r\n洒脱\r\n生性豁达，金庸说“论风流多艺我不如蔡澜，他是一个真正潇洒的人”，倪匡说“蔡澜是少有背后没有人说他坏话的人”，黄霑说“蔡澜是我最值得信赖的朋友”。', 3, '28.32', '55.00'),
(17, '北野武的小酒馆', '北野武', '9787513328081', 100, 'http://localhost:8080/resources/18.jpg', '日本殿堂级导演、毒舌北野武酒馆漫谈，词锋犀利、畅言无忌\r\n从生死、教育、人际关系、规矩、电影五个方面\r\n直指现代社会病灶，唤醒大众逆位思考\r\n\r\n日本殿堂级导演北野武，犀利自剖前半生，“那场车祸是我人生的转折点，从此我对活着失去了兴趣”，“为了成就我一个，成千上万的人倒了下去”。\r\n北野武酒馆漫谈，词锋犀利、畅言无忌，毒舌炮轰社会不良现象，撕开世界温和假面。\r\n“人是不平等的，不管你多努力，做不到的事情就是做不到”“正因为说什么‘大家都是好朋友’，才使得欺负人的手段变得越来越阴险”。\r\n生死、教育、人际关系、规矩、电影，五个直指现代社会病灶，唤醒大众逆位思考。', '北野武 Takeshi Kitano 1947—\r\n日本著名导演、演员。\r\n\r\n1947年出生于日本东京。26岁成为漫才演员，以其无厘头的辛辣和黑色幽默成为日本80年代喜剧热潮的灵魂人物。之后更涉足广播电视、电影和出版，佳作频出。主要电影作品包括《花火》《坏孩子的天空》《菊次郎的夏天》等。主要文字作品有《浅草小子》《毒舌北野武》《菊次郎与佐纪》等。\r\n\r\n姜向明\r\n日本静冈大学欧美文学系毕业，上海翻译家协会会员。嗜读外国文学，长期从事文学翻译与研究，译文多次发表于《外国文艺》《译文》等杂志。', 3, '26.55', '45.00'),
(18, '德国极简史', '詹姆斯·霍斯 (James Hawes)', '9787540489120', 100, 'http://localhost:8080/resources/19.jpg', '作者：（英国）詹姆斯·霍斯（James Hawes）\r\n\r\n英国小说家、历史学家。出生于1960年。在牛津大学赫特福德学院学习德语，毕业后在威尔士短暂研习戏剧，而后前往西班牙任英语老师。1987至1989年，在伦敦大学学院攻读博士学位，研究方向是尼采和德国文学。其后在梅努斯大学、谢菲尔德大学和斯旺西大学担任德语讲师。目前负责布鲁克斯大学创意写作课程。\r\n霍斯出版了6部小说，其中两本被改编为电影剧本。《为英格兰辩护》预言了英国脱欧事件，传记作品《卡夫卡考》引起巨大轰动。《英国佬与德国佬》从全新角度审视19世纪后期英国和德国的关系。\r\n新作《德国极简史》广受好评，一度位列《星期日泰晤士报》大众平装书榜榜单第二名。《经济学家》称之为“必读书”，水石书店将其列为全英月度非虚构类好书。', '《德国极简史》出版后即荣登欧美各大国际媒体、书店的销量榜，成为备受瞩目的年度历史类图书，所获成绩包括：《星期日泰晤士报》周销量榜No.2，仅次于《人类简史》；《泰晤士报》销量榜首；《星期日泰晤士报》年度销量总榜Top 10；长期位列德国《明镜周刊》销量榜单；水石书店月度非虚构类好书……\r\n《黄金罗盘》作者菲利普·普尔曼盛赞：“全面而生动，没有比本书更好的德国简史了。”《经济学人》《卫报》《泰晤士报》《明镜周刊》《旁观者》等众多媒体推荐：“精彩”“文采斐然”“有趣”“你一定爱读的《德国极简史》”。剑桥大学、牛津大学等国际一流院校学者、教授一致推荐：“一次令人兴奋的阅读体验”“扎实的研究和彻底的反思”。 \r\n以200多页的精悍叙述、100多张生动配图，展现了公元前58年至今近2000年间，以日耳曼民族为主体的德意志人的历史进程，把德国历史放在欧洲乃至西方世界的大背景中观察、分析、探究，从欧洲纵横交错的小国割据和日耳曼人众多分支的发展中，对现代德国的历史脉络进行追踪和梳理，选取了影响德国历史进程的重大事件、关键时刻，勾勒德意志民族和德国的发展轮廓。理论新颖、明白晓畅。', 4, '33.04', '56.00'),
(19, '明朝那些事儿', '当年明月', '7559602150', 100, 'http://localhost:8080/resources/20.jpg', '《明朝那些事儿(增补版)(套装共9册)》包括：《明朝那些事儿（第1部）》、《明朝那些事儿（第2部）》、《明朝那些事儿（第3部）》、《明朝那些事儿（第4部）》、《明朝那些事儿（第5部）》、《明朝那些事儿（第6部）》、《明朝那些事儿（第7部）》、《明朝那些事儿（第8部）》、《明朝那些事儿（第9部）》共9册。《明朝那些事儿(增补版)(套装共9册)》全景立体式图文阅读体验，原文一字不少，新增四大板块全新内容——延伸内容、插图、图表、地图。涉及关键词解析、历史背景及相关插图、作战图、形势图、人物关系图等。图解历史，小细节、大事件一目了然，通俗易懂。', '明月的写作不仅笔锋活泼幽默，而且加进了自己的感悟，这就拉近了作者与读者的距离，也拉近了古人与今人的距离。\r\n——著名明史专家毛佩琦\r\n我特想跟写《明朝那些事儿》的人聊，那本书很好。\r\n我觉得喜欢看的人都是有思想、愿意想事情的人，这是本好书，除了把史实摆出来，还要评论、挖掘，用现代的语言去说，他有他的角度。\r\n——联想集团创始人柳传志\r\n看看《明朝那些事儿》，对朱元璋起兵时的心态分析，就知道我的意思。老朱当时起兵是死，不起兵也是死，最后与其等死，不如战死。陈胜、吴广也是。这就叫，不做皇帝不行了，所以做皇帝。\r\n——新东方创始人之一、过来人董事徐小平\r\n我很赞成《明朝那些事儿》对历史的解读，毕竟历史是一堆堆故事和生动的人物组成，用老百姓喜欢接受的方式让他们去了解，是好事。\r\n——著名作家、历史学者吴思\r\n这几天我连续在看《明朝那些事儿》，真是写得好看。\r\n——香港凤凰卫视主持人窦文涛\r\n《明朝那些事儿》写得好，写得比较放松，我们过去写的人都拘着，生怕哪块做得不合适。\r\n——著名收藏家马未都', 4, '172.90', '297.00'),
(20, '阿司匹林传奇', '迪尔米德·杰弗里斯(Diarmuid Jeffreys)', '7108034093', 100, 'http://localhost:8080/resources/21.jpg', '《阿司匹林传奇》是新知文库。', '作者：（英国）迪尔米德·杰弗里斯（Diarmuid Jeffreys） 译者：暴永宁 王惠\r\n\r\n迪尔米德·杰弗里斯（Diarmuid Jeffreys），英国作家、记者、电视制片人，供职于英国广播公司（BBC）.', 5, '51.92', '65.00'),
(21, '谷物大脑', '戴维·珀尔马特(David Perlmutter)', '7111499417', 100, 'http://localhost:8080/resources/22.jpg', '美国健康类 畅销书！\r\n出版80周长踞Amazon健康类排行榜第1名！\r\n甫出版，即登上《纽约时报》畅销书榜第1名！\r\n《纽约时报》畅销书榜连续在榜55周！\r\n《美国出版周报》畅销书榜连续在榜超40周！\r\n\r\n好莱坞和运动界明星都在使用无麸质饮食法！\r\n无麸质饮食法帮助小德获得43连胜、8次大满贯，并坐上了世界 宝座！\r\n美国名模辛迪?克劳馥、好莱坞女星格温妮斯?帕特洛、麦莉?赛勒斯、美国前 千金切尔西?克林顿、NBA明星球员史蒂夫?纳什、台湾著名作家胡因梦、日本著名演员中谷美纪等诸多名人都在使用无麸质饮食法！革命性的饮食法，颠覆了欧美人的饮食习惯！\r\n欧美掀无麸质饮食潮流，有高达1／3的美国人试图避免食用麸质\r\n美国无麸质食品市场规模增长至42亿美元，无麸质比萨、无麸质啤酒开始流行\r\n你的大脑会生病，并非遗传基因早注定，\r\n罪魁祸首，正是你每天所吃的食物！\r\n麸质、碳水化合物和糖，\r\n就像“沉默的杀手”，\r\n在你毫无知觉的时候，\r\n已对你的大脑与身体造成永久的损害。\r\n你的大脑\r\n重达3磅，血管总计长达10万英里。\r\n拥有的神经元数量比银河中的星星还多。\r\n是人体中脂肪最多的器官。\r\n可能此刻正在遭受危害，而你却对此一无所知……', '戴维·珀尔马特\r\n（David Perlmutter）\r\n戴维·珀尔马特医学博士是一名具有专科医师资格的执业神经科医生，并且是美国营养学院的成员。他创办了佛罗里达珀尔马特健康中心和珀尔马特脑部研究基金会。\r\n在营养对神经病症的影响这个研究领域，珀尔马特博士是世界公认的权威。他曾获多项奖章，包括迈阿密大学医学院颁发的朗特里研究奖、美国营养学会颁发的年度人道主义奖，以及因他在神经退行性疾病领域的开创性研究而荣获的莱纳斯?鲍林奖。\r\n他的文章广泛地出现在医学出版物中，而且他在世界各地举办讲座。珀尔马特医生是《奥兹医生秀》医学顾问团的成员，还在多个全国性电台和电视节目中登场，其中包括美国有线电视新闻网（CNN）和福克斯新闻频道的《20/20》、《今日》、《早安美国》以及《早间秀》。\r\n珀尔马特医学博士已出版的著作有《健脑书》（The Better Brain Book）、《五岁前的IQ大跃进》（Raise a Smarter Child by Kindergarten）和《为大脑充电》（Power Up Your Brain）。《谷物大脑》一书在美国甫出版即跃上《纽约时报》图书销售排行榜第一名以及Amazon健康类排行榜第一名。', 5, '32.20', '45.00'),
(22, 'ABC幼儿双语启蒙认知绘本', '赵君', '7541483354', 100, 'http://localhost:8080/resources/23.jpg', '1.认知方向明确——八个针对性日常趣味小故事，八大成长必备认知本领（数字、形状、颜色、分类、感觉、方位、对比、服饰）全面启蒙。\r\n2.英文简单易懂——中英双语，英语为主，能够让宝宝从认知开始就接触基础的英语词汇，在认知中提升语感，进行左右脑思维开发训练，同时拥有双母语。\r\n3.重点词汇突出——针对认知点的中英文重点词汇均做了单独突出，便于孩子重点掌握，强化记忆。\r\n4.故事好玩有趣——画面童趣温馨，色彩鲜艳，故事惊喜不断，能够刺激宝宝的视觉与想象力，全方位锻炼孩子的认知能力，并且让孩子爱上阅读。\r\n5.亲子互动性强——故事贴近日常，父母可以根据绘本中的故事自行发挥，通过绘本中的方式延伸与孩子的互动游戏，强化孩子的认知记忆。', NULL, 6, '73.00', '120.00'),
(23, '中央人民广播电台教学节目用书:新版中日交流标准日本语初级(第2版)(套装共2册)', '人民教育出版社', '9787107278303', 100, 'http://localhost:8080/resources/24.jpg', '《新版中日交流标准日本语 初级》上、下（第二版）精心策划，官方出品：中日双方编写者再次倾情奉献，精心设计，继续打造人教精品；与最新版教材同步，适合新日本语能力考试用书；手机阅读，离线使用：把《新版标准日本语》装进手机，出行学习不用背书，资源包单独下载，随时随地无流量、离线学习；新版内容，轻松学习：权威语法解释，精良互动练习，让书本知识变得有声有色，让日语学习不再枯燥，实现轻松、快乐学习；内容全面，逐步更新：五十音图示范教学，课文、生词中日文对照，音视频与内容同步播放，随时更新，让日语学习永远学在前沿。', NULL, 6, '71.50', '78.00'),
(24, '鸡是半圆形,猫是圆形', '罗莎•玛丽亚•柯托（Rosa M.Curto）', '9787548416593', 100, 'http://localhost:8080/resources/25.jpg', '《鸡是半圆形，猫是圆形》8种几何图形的创意简笔画。萌翻欧美的创意简笔画，一分钟画出萌物，令人脑洞大开、全面发散思维。\r\n★ 什么？！鸡是半圆形？猫是圆形？本书让热爱画画的你脑洞大开\r\n★ 天马行空，创意无限！来自西班牙萌翻全世界的快乐简笔画入门\r\n★ 全彩色印刷，老少皆宜，一学就会！赶快开启一段奇妙的绘画旅程吧', '作者：罗莎•玛丽亚•柯托（Rosa M.Curto），西班牙著名插画家，自19岁起开始担任儿童绘画教师，她多样化的插图遍布于儿童读物、卡通电影、广告和杂志上，其作品在美国、英国、阿根廷、比利时、巴西、丹麦等30多个国家都可看到。目前已出版的儿童绘本作品多达40本以上。', 7, '37.60', '69.80'),
(25, '历代名瓷图谱', '项元汴', '9787534054365', 100, 'http://localhost:8080/resources/26.jpg', '图谱对传统视觉艺术及艺术社会学的研究具重要价值，尤其是画师通过传统中国画形式描摹多种窑口瓷器的形製、款式、色泽和质地的艺术手法，对于当下理解、学习和继承传统博古画这一特色绘画形式具有珍贵的借鉴意义；同时，图谱收録之古代文房珍玩、燕几清供类器物如香炉、砚台、笔搁、笔洗、花瓶、水罐、酒罐、酒杯、茶壶、茶杯、茶托、饭碗、盘子、香盒、灯座、烛台等，对于今天的工艺美术研究也有直观的惨考价值。', '项元汴(1525—1590)，字子京，号墨林，别号墨林山人、墨林居士、漆员傲吏等，浙江嘉兴人。明国子生，著名收藏家、鉴赏家、书画家。\r\n英译者卜士礼（StephenWootton Bushell，1844 － 1908），英国医生、东方学家。卜士礼出生于英国肯特郡，毕业于伦敦大学盖伊医学院，1868 年获伦敦大学医学博士学位。同年前往北京担任英国驻华使馆医师，并兼任京师同文馆医学教习。卜氏居留中国三十馀年，其间不仅精通了中文，还撰写了许多关于中国艺术、地理、历史等方面的专著与论文，其中最著者如《中国美术》出版后广受好评。', 7, '145.00', '198.00'),
(26, '世界咖啡地图(全球公认的咖啡圣经,咖啡迷心念收藏的终极指南,世界咖啡师大赛冠军代表作) ', '詹姆斯·霍夫曼（James Hoffmann）', '9787508661148', 100, 'http://localhost:8080/resources/27.jpg', '《世界咖啡地图》是全球公认的咖啡圣经！雄踞美国、英国等国亚马逊网站咖啡类图书榜首，荣登《经济学人》年度饮食类图书榜。作者詹姆斯•霍夫曼，2007年世界咖啡师大赛冠军，他走遍全球各大产区搜集一手信息。儒雅的他，以贴近读者的方式娓娓道来，带领大家探索咖啡世界的奥秘，帮助入门者轻松建立整体知识框架，使资深者受益于所分享的心得经验。\r\n书中以卓越的见解，讲述关于咖啡的一切：咖啡的历史和全球产业链、采收及加工处理、烘焙与冲煮方式、29大产区的特色详解……《世界咖啡地图》系统全面、语言优美、见解精妙，是咖啡迷必备的权威百科全书。\r\n《世界咖啡地图》是一本美丽的咖啡全球指南，封面采用仿咖啡豆袋纸，手感十足；内文收录有上百幅全彩图片、地图和插画，是令咖啡迷们爱不释手、心念收藏的经典工具书。\r\n\r\n一本有态度有内涵又有颜值的咖啡百科书。\r\n\r\n先是爱上这本书的颜值，仿咖啡豆麻袋纸的封面一下就把人带入到咖啡的世界，书内配图也都有着十足的质感。细细读来，又发现内容同样精彩，从一颗生豆到一杯咖啡，你所能想到的关于咖啡的种种问题相信都能在这本书中找到答案，而且重要的是，语言完全不枯燥，有趣且好读。不过让我觉得最赞的是作者在书中流露出的认真严谨且毫不浮夸的写书态度。作为2007年在世界咖啡师大赛（WBC）的冠军，詹姆斯客观考究的讲解着关于咖啡的一切，细节中处处蕴含着作者的认真与幽默。相信这本书会是带你踏入咖啡世界大门的好伙伴。\r\n——亚马逊王大强', '英)詹姆斯·霍夫曼（James Hoffmann），著名咖啡师、烘焙专家，咖啡界传奇人物。\r\n2007年在世界咖啡师大赛（WBC）荣获冠军，2008年赢得英国杯测大赛冠军，2011年拿下英国手冲杯冠军。后在伦敦与朋友一同创办了知名的Square Mile咖啡烘焙品牌，培育出独特的伦敦咖啡文化。近年与Nuova Simonelli合作，设计研发出划时代的黑鹰咖啡机，极大地提高了咖啡出品的稳定性，成为众多咖啡师赞不绝口的利器。', 8, '116.82', '198.00'),
(27, '孤独星球Loney Planet:奥地利', '澳大利亚Lonely Planet公司', '9787520410359', 100, 'http://localhost:8080/resources/28.jpg', '奥地利可能会让人眼前浮现巴洛克教堂风格的画面，一如美泉宫般宏伟的哈布斯堡建筑，还有像斯蒂芬大教堂那样散发着辉煌光\r\n芒的哥特式建筑。但这个国家不只有浮华和宫殿。城市间也吹拂着清新的建筑风气，带来新鲜和活力，将现代与历史和谐交融。其中一些引人注目的标志性建筑反而是新近兴建的：翻新自皇家马厩的维也纳博物馆区、色彩艳丽犹如鲁比克魔方一般的林茨电子艺术中心，还有充满科幻感的格拉茨美术馆。', '澳大利亚Lonely Planet公司是全球领先的旅行内容提供商，40多年来坚持不懈地为渴望旅行的人们提供优质的旅行信息服务。\r\nLonely Planet约占全球英文旅行指南销售量的四分之一，堪称旅行者的“标配”。从2012年起，Lonely Planet与中国地图出版集团携手，在中国大陆打造中文简体版的Lonely Planet旅行指南，截至2017年底共出版了217种“孤独星球”系列图书。其中，国内目的地皆由中国本地的作者亲赴实地调研，并按照Lonely Planet国际旅行指南的风格撰写，旨在为国内游的读者提供更为精准的服务。\r\n除了以全面、深入、客观、实用而著称的经典“蓝脊”旅行指南，“孤独星球”系列图书还包含面向不同阅读人群和旅行需求的更多品种：全彩精致的“IN”指南系列，小巧轻便的“口袋指南”系列，精华线路云集的“自驾指南”系列，灵感火花四溅的旅行读物系列。而无论大小厚薄、轻重俭奢，Lonely Planet都以“负责任的旅行，有态度的探索”，及“有用、有意义和有趣”的呈现方式，将世界无限的可能性和旅行者联结起来。', 8, '79.40', '89.00'),
(28, 'Harry Potter: The Complete Collection (English Edition)', 'J.K. Rowling', '1408856786', 50, 'http://localhost:8080/resources/29.jpg', 'I\'ve yet to meet a ten-year-old who hasn\'t been entranced by its witty, complex plot and the character of the eponymous Harry * Independent * Spellbinding, enchanting, bewitching stuff * Mirror * Teachers say a chapter can silence the most rowdy of classes * Guardian * One of the greatest literary adventures of modern times * Sunday Telegraph * The Harry Potter stories will join that small group of children\'s books which are read and reread into adulthood * TLS *', 'Harry Potter and the Philosopher\'s Stone was J.K. Rowling\'s first novel, followed by the subsequent six titles in the Harry Potter series, as well as three books written for charity: Fantastic Beasts and Where to Find Them, Quidditch Through the Ages and The Tales of Beedle the Bard. The Harry Potter novels have now sold over 450 million copies worldwide and been translated into 77 languages.', 9, '697.00', '697.00'),
(29, 'A Game of Thrones 5-Book Boxed Set ', 'George R.R. Martin', '0007477155', 100, 'http://localhost:8080/resources/30.jpg', 'Of those who work in the grand epic fantasy tradition, Martin is by far the best’\r\nTime Magazine\r\n\r\n‘Colossal, staggering… Martin captures all the intoxicating complexity of the Wars of the Roses or Imperial Rome’\r\nSFX\r\n\r\n‘The sheer-mind-boggling scope of this epic has sent other fantasy writers away shaking their heads… Its ambition: to construct the Twelve Caesars of fantasy fiction, with characters so venomous they could eat the Borgias.’\r\nGuardian', 'George R.R. Martin is the author of fourteen novels, including five volumes of A SONG OF ICE AND FIRE, several collections of short stories and numerous screen plays for television drama and feature films. He lives in Santa Fe, New Mexico.', 9, '219.90', '209.00');

-- --------------------------------------------------------

--
-- 表的结构 `book_carousel`
--

CREATE TABLE `book_carousel` (
  `ID` int(11) NOT NULL,
  `bookID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
-- 表的结构 `book_tab`
--

CREATE TABLE `book_tab` (
  `ID` int(11) NOT NULL,
  `bookID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
(2, 17, 27, 4),
(14, 1, 2, 6);

-- --------------------------------------------------------

--
-- 表的结构 `comment`
--

CREATE TABLE `comment` (
  `ID` int(11) NOT NULL,
  `content` text NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `score` int(11) NOT NULL,
  `userID` int(11) NOT NULL,
  `bookID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `comment`
--

INSERT INTO `comment` (`ID`, `content`, `time`, `score`, `userID`, `bookID`) VALUES
(1, '我很喜欢这本书啊', '2019-04-21 22:00:00', 5, 1, 1),
(2, '买了买了', '2019-04-21 22:00:00', 5, 1, 1),
(3, '很好的一本书。', '2019-04-28 13:57:28', 4, 1, 2),
(4, '很棒', '2019-04-28 16:48:35', 4, 1, 3),
(5, '太喜欢了', '2019-04-28 16:49:40', 5, 1, 3),
(6, '可以', '2019-04-29 07:00:16', 4, 17, 3);

-- --------------------------------------------------------

--
-- 表的结构 `deal`
--

CREATE TABLE `deal` (
  `ID` int(11) NOT NULL,
  `userID` int(11) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `address` varchar(255) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `total_price` decimal(10,2) NOT NULL,
  `receiver` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `deal`
--

INSERT INTO `deal` (`ID`, `userID`, `phone`, `address`, `time`, `total_price`, `receiver`) VALUES
(1, 1, '18217508975', '上海市闵行区东川路800号交通大学东16', '2019-04-22 22:00:00', '80.00', 'admin'),
(6, 1, '18217508975', '上海市闵行区东川路800号交通大学', '2019-04-28 03:14:13', '84.00', 'admin'),
(7, 1, '18217508975', '交通大学', '2019-04-28 06:25:59', '213.92', 'admin'),
(8, 1, '13339666038', '交通大学', '2019-04-28 11:46:59', '80.60', 'admin'),
(9, 1, '18217508975', '交通大学', '2019-04-28 11:50:51', '1557.60', 'admin'),
(10, 1, '12345872934', '交通大学', '2019-04-28 12:08:27', '80.60', 'admin'),
(11, 1, '18217508975', '交通大学', '2019-04-28 12:35:24', '322.40', 'admin'),
(12, 1, '12345872934', '交通大学', '2019-04-28 12:53:13', '108.92', '翠花'),
(14, 17, '18217508975', '交通大学', '2019-04-29 07:50:19', '660.00', '翠花'),
(15, 1, '12345872934', '交通大学', '2019-04-29 08:16:16', '33.04', '翠花'),
(19, 1, '18217508975', '交通大学', '2019-04-29 11:27:15', '188.80', '翠花'),
(20, 1, '18217508975', '交通大学', '2019-04-29 11:42:00', '887.72', '翠花'),
(21, 1, '12345872934', '交通大学', '2019-04-29 11:43:53', '80.60', '翠花'),
(22, 1, '18217508975', '交通大学', '2019-04-29 11:44:20', '37.76', '翠花'),
(23, 1, '18217508975', '交通大学', '2019-04-29 12:49:49', '207.24', 'sjtu');

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

INSERT INTO `deal_book` (`ID`, `bookID`, `ammount`, `dealID`) VALUES
(1, 1, 1, 1),
(2, 2, 1, 1),
(5, 1, 2, 6),
(6, 3, 1, 6),
(7, 3, 1, 7),
(8, 2, 1, 7),
(9, 6, 1, 7),
(10, 2, 1, 8),
(11, 3, 30, 9),
(12, 2, 1, 10),
(13, 2, 4, 11),
(14, 2, 1, 12),
(15, 16, 1, 12),
(17, 1, 30, 14),
(18, 18, 1, 15),
(22, 4, 10, 19),
(23, 3, 15, 20),
(24, 2, 1, 20),
(25, 16, 1, 20),
(26, 2, 1, 21),
(27, 4, 2, 22),
(28, 3, 2, 23),
(29, 6, 1, 23),
(30, 1, 1, 23);

-- --------------------------------------------------------

--
-- 表的结构 `user`
--

CREATE TABLE `user` (
  `ID` int(11) NOT NULL,
  `username` varchar(50) CHARACTER SET utf8mb4 NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(50) CHARACTER SET utf8mb4 NOT NULL,
  `role` varchar(255) NOT NULL DEFAULT 'USER',
  `status` tinyint(4) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `user`
--

INSERT INTO `user` (`ID`, `username`, `password`, `email`, `role`, `status`) VALUES
(1, 'admin', '$2a$10$jDikfFD4CnON0lonl08/2e1cZEOfdG58EbTfUQly0jlXo1tePui0S', '1035254583@qq.com', 'ADMIN', 1),
(15, 'user1', '$2a$10$e8OK/Wuq.cgiG9HCKZs51.n1AKoqxVNvg5zg5Di2j6d1aSdaEgVpS', '1035254583@qq.com', 'USER', 1),
(16, 'user2', '$2a$10$YHyl9./tE9Ya1.3lTHTor.YUBio9ShyO/z0g5l7KIgBBEFbDLLcdi', '1035254583@qq.com', 'USER', 1),
(17, '翠花', '$2a$10$eO.xAIBTPQ8/pvMHQy2YF.tcf9FkEMRIirPhWQ4ueFHmvLjZw82Vi', '1035254583@qq.com', 'USER', 1);

--
-- 转储表的索引
--

--
-- 表的索引 `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`ID`);

--
-- 表的索引 `book_carousel`
--
ALTER TABLE `book_carousel`
  ADD PRIMARY KEY (`ID`);

--
-- 表的索引 `book_category`
--
ALTER TABLE `book_category`
  ADD PRIMARY KEY (`ID`);

--
-- 表的索引 `book_tab`
--
ALTER TABLE `book_tab`
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
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- 使用表AUTO_INCREMENT `book_category`
--
ALTER TABLE `book_category`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- 使用表AUTO_INCREMENT `cart`
--
ALTER TABLE `cart`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- 使用表AUTO_INCREMENT `comment`
--
ALTER TABLE `comment`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- 使用表AUTO_INCREMENT `deal`
--
ALTER TABLE `deal`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- 使用表AUTO_INCREMENT `deal_book`
--
ALTER TABLE `deal_book`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- 使用表AUTO_INCREMENT `user`
--
ALTER TABLE `user`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
