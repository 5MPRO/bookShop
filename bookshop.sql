-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 27, 2021 lúc 10:09 AM
-- Phiên bản máy phục vụ: 10.4.22-MariaDB
-- Phiên bản PHP: 8.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `bookshop`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietdonhang`
--

CREATE TABLE `chitietdonhang` (
  `id` int(11) NOT NULL,
  `maDonHang` int(11) NOT NULL,
  `maSanPham` int(11) NOT NULL,
  `tenSanPham` varchar(10000) COLLATE utf8_unicode_ci NOT NULL,
  `giaSanPham` int(11) NOT NULL,
  `soLuongSanPham` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `chitietdonhang`
--

INSERT INTO `chitietdonhang` (`id`, `maDonHang`, `maSanPham`, `tenSanPham`, `giaSanPham`, `soLuongSanPham`) VALUES
(1, 15, 2, 'Thám Tử Kindaichi R - Tập 1', 22000, 1),
(2, 16, 1, 'Pokemon Pippi trọn bộ 14 tập', 1172000, 4),
(3, 16, 6, 'CHUỘC TỘI', 291000, 3),
(4, 17, 1, 'Pokemon Pippi trọn bộ 14 tập', 293000, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `donhang`
--

CREATE TABLE `donhang` (
  `id` int(11) NOT NULL,
  `tenKhachHang` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `soDienThoai` int(11) NOT NULL,
  `email` varchar(200) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `donhang`
--

INSERT INTO `donhang` (`id`, `tenKhachHang`, `soDienThoai`, `email`) VALUES
(13, 'Bui Van Sy', 921321, 'bvsy@gmail.cm'),
(14, 'Pvthien', 1544, 'djsadsa'),
(15, '1', 1, '1'),
(16, '1', 1, '1'),
(17, '2', 2, '2');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loaisanpham`
--

CREATE TABLE `loaisanpham` (
  `id` int(11) NOT NULL,
  `tenLoaiSanPham` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `hinhAnhLoaiSanPham` varchar(200) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `loaisanpham`
--

INSERT INTO `loaisanpham` (`id`, `tenLoaiSanPham`, `hinhAnhLoaiSanPham`) VALUES
(1, 'Truyện tranh', 'https://img.websosanh.vn/v10/users/review/images/aeq4glcfiy24v/bo-truyen-tranh-doremon.jpg?compress=85'),
(2, 'Văn học', 'https://cdn0.fahasa.com/media/catalog/product/b/i/biamem.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanpham`
--

CREATE TABLE `sanpham` (
  `id` int(11) NOT NULL,
  `tenSanPham` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `giaSanPham` int(11) NOT NULL,
  `hinhAnhSanPham` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `moTaSanPham` varchar(10000) COLLATE utf8_unicode_ci NOT NULL,
  `idSanPham` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `sanpham`
--

INSERT INTO `sanpham` (`id`, `tenSanPham`, `giaSanPham`, `hinhAnhSanPham`, `moTaSanPham`, `idSanPham`) VALUES
(1, 'Pokemon Pippi', 293000, 'https://cf.shopee.vn/file/6ead4762689ca20c055bb4ce16552df4', 'Vốn là một cái cô nhi, Kaitou Izumi từ khi sinh ra đã không biết mặt ba mẹ mình, sống tại cô nhi viện, đứa trẻ vẫn luôn phải tìm cách tự thân sinh tồn, học tập cách nhìn sắc mặt người khác.\r\n\r\nLớn lên một chút, bắt đầu đi học Kaitou vẫn luôn cố gắng đạt được thành tích cao nhất có thể, tuy nhiên thiên phú không đủ lực học của cậu chỉ nằm ở dạng trung du.\r\n\r\nNhưng không vì vậy mà cậu bỏ cuộc hay thất vọng, học cấp ba Kaitou bắt đầu ra ngoài làm công, sớm một chút kiếm ít tiền trang trải cuộc sống.\r\n\r\nCàng ở lúc tốt nghiệp trung học xong, khi cô nhi viện không còn trách nhiệm nuôi dưỡng cậu nữa, Kaitou mang theo hành lý bắt đầu cuộc sống tự lập.\r\n\r\nLàm việc với vai trò người check lỗi của công ty game, lương tháng của Kaitou tuy không cao, nhưng vẫn đủ để cậu trang trải.\r\n\r\nĂn uống tiết kiệm, công việc lại nặng nề, lần này cậu nhận được công việc check lỗi cho một tựa game mới, lấy bối cảnh pokemon thế giới, bộ anime này hầu như không ai không biết Kaitou hiển nhiên là nắm rõ.\r\n\r\nĐặc biệt là khi càng nhiều phần anime hoạt họa của trò chơi này được làm ra, Kaitou Izumi coi như một cái fans nhỏ liền cắm đầu khai thác thông tin trò chơi.\r\n\r\nĐể có được nhiều phân thời gian nghỉ cuối tuần hơn, Kaitou liền cật lực ra sức, thậm chí đến đêm vẫn không về nhà tăng ca làm việc, để rồi thời gian dài lao lực cậu kiệt sức nằm gục trên bàn.\r\n\r\nĐợi đến khi tỉnh lại, Kaitou đã xuất hiện ở một nơi khác, khung cảnh một ngôi nhà hoa lệ hoành tráng hiện ra trước mặt cậu, cậu giật mình kêu lên vài tiếng, nhưng phát ra chỉ là vài ú ớ thanh âm.\r\n\r\n‘Cái gì vậy?’ Katiou ở trong đầu nghi hoặc, rõ ràng là trước đây một lúc cậu vẫn đang ngồi trên bàn làm việc nằm ngủ, sao giờ lại ở một nơi kỳ lạ như vậy.\r\n\r\nHơn nữa cái cảm giác không làm chủ được thân thể này thật khó chịu, giơ tay nhấc chân đủ khiến cậu thật sâu mệt mỏi.', 1),
(2, 'Thám Tử Kindaichi ', 22000, 'https://vn-test-11.slatic.net/p/e54f8dacb6d9cb88c9cedff0392816a8.jpg', 'Kindaichi Hajime (tên thường gọi là Kindaichi) là một cậu học sinh trung học ở trường Litong nổi tiếng quậy quá, nghịch ngợm, chuyên đi học trễ nhưng luôn là học sinh đứng đầu lớp. Thực chất Kindaichi là một người có cá tính mạnh mẽ, rất thông minh (có chỉ số IQ là 180) cùng với những suy luận sắc bén vì cậu ta là người có một dòng máu \"thiên tài\" từ ông nội của mình là một nhà thám tử nổi tiếng đại tài Hajime. Kindaichi có một cô bạn gái thân với nhau từ nhỏ là Nanase Miyuki, một cô gái dễ thương có tính tình đáng yêu và được rất nhiều cậu con trai đào hoa phong nhả để ý nhưng cô chỉ luôn đi theo Kindaichi dù cậu ta là một người quậy phá, vô tích sự. Kindaichi cùng với cô bạn thân Miyuki luôn phiêu lưu vào những vụ án ghê rợn, đẫm máu và đầy bí ẩn thử thách của những kẻ giết người tàn ác. Hai viên cảnh sát thường có mặt trong truyện luôn được Kindaichi hỗ trợ phá án qua những vụ án mạng là Kenmochi Isamu và Akechi Kengo.\r\n\r\nCái hay ở tập truyện Thám tử Kindaichi Những tập truyện Kindaichi lôi cuốn người đọc với những vụ giết người huyền bí và những màn phá án tuyệt vời của một cậu học sinh trung học. Những vụ án trong truyện thường là những vụ giết người trong phòng kín hay trên đảo hoang với những manh mối đặc sắc kèm theo những lời bí ẩn để lại tại hiện trường và hung thủ là những người quen thuộc đồng hành từ đầu tập. Điều đáng chú ý ở Thám tử Kindaichi là kẻ giết người không bị tâm thần và những vụ giết người không vì lợi ích cá nhân. Những hung thủ bị vạch trần thường là do tổn thương nặng về tâm lí hoặc tình cảm vì nạn nhân gây ra cho mình trong quá khứ và có khi bắt nguồn từ lòng hận thù, ghen ghét đố kị, tham lam mù quáng, thói chuộng hư danh, ham muốn tiền tài vật chất v.v. Nói chung tính chất tội phạm là do bắt nguồn từ ý muốn tham vọng cá nhân, thỏa mạn dục vọng thấp hèn của con người.\r\n\r\nNgoài những vụ án li kì hấp dẫn hồi hộp qua những pha phá án sắc sảo, những tập truyện Thám tử Kindaichi còn giáo dục cho thanh niên sống ngày nay phải bằng chính năng lực của mình, sống đúng với pháp luật, tội ác luôn bị trừng trị và cộng lí công bằng trong xã hội.', 1),
(3, 'XU XU ĐỪNG KHÓC', 73600, 'https://newshop.vn/public/uploads/products/42863/sach-xu-xu-dung-khoc.jpg', 'Buổi thi kết thúc lúc 12h10 phút, tôi nghĩ chắc là Đu Đu cũng ko tới kịp.\r\n\r\nmấy bạn trong lớp tôi và lớp 11B xúm xít quanh Long và Lãm\r\n\r\ntôi lủi thủi ra về…\r\n\r\n“Xuân!”\r\n\r\n“oh…Kim… nhóm Kim có thắng ko?”\r\n\r\n“nhóm Kim thua rồi ^-^ nhưng mà, lúc thi văn nghệ, nghe nói Xuân múa vui lắm?”\r\n\r\n“thôi… khùng thấy mồ…”\r\n\r\n“thắng là tốt rồi, tuần sau cố giật giải nhé!!”\r\n\r\ncũng may mà tôi còn có 1 người bạn tốt, là Hương Kim..\r\n\r\nnếu ko chắc tôi khóc vì tủi thân quá…huhu…\r\n\r\n“hey, XU XU!! chờ đã…”\r\n\r\nLong chạy theo tôi, gọi í ới, nhưng rồi giọng cậu ấy loãng dần, trong vòng vây rất nhiều bạn bè và “fans hâm mộ”…\r\n\r\nhình như họ bảo phải đi ăn mừng.\r\n\r\ntôi tíêp tục cúi đi thêm vài bước…\r\n\r\nmột bàn tay nắm khuỷu tay tôi kéo lại.\r\n\r\n“đợi chút, đi chung luôn.”\r\n\r\ngiọng Lãm hơi khô khốc, nét mặt nửa nài ép, nửa kêu gọi, tôi lắc đầu khe khẽ, ko muốn tham gia, nếu phải ngồi như con ốc sên, thà là tôi về nhà.\r\n\r\n“hay để tôi về với Xuân?”\r\n\r\n“ko, cậu cứ ở lại.. tớ mệt lắm, chắc là tớ…”\r\n\r\n“XUUU XUUU~!!”\r\n\r\ncái tiếng gọi “thảm thiết” của Long\r\n\r\ncắt lời tôi và sau đó là cậu ấy nhào tới, chen vào giữa và khóac vai 2 chúng tôi.\r\n\r\n“2 người định đi mà ko có tôi à?”\r\n\r\n“mày có đi với tụi nó ko?”\r\n\r\n“ko đi sao được, tụi nó cổ động mình quá trời!”\r\n\r\n“vậy Long đi với họ đi, tớ về thôi.”\r\n\r\n“Xu Xu ko thích đi với bọn họ sao?”\r\n\r\n“ko phải, chỉ là…”\r\n\r\n…….ko đợi tôi nói hết câu, Long quay lại đám bạn, nói hơi lớn giọng, kiểu như đại ca vậy..\r\n\r\n“eh, mai học xong tôi sẽ đi với mọi người, hôm nay bọn tôi cần bàn việc riêng!!”\r\n\r\n“vậy là sao… sao thế… việc riêng gì…”\r\n\r\n“kỳ dzị…??”\r\n\r\nđám bạn cứ nhao nhao thắc mắc, nhưng với thái độ của Long, thì coi như ko ai có thể thay đổi được quyết định của cậu ấy, cho dù ngừơi đó là Lãm, hay cả tôi nữa.', 2),
(4, 'THIÊN THẦN MÙ SƯƠNG', 92000, 'https://newshop.vn/public/uploads/products/23812/thien-than-mu-suong-bia.jpg', 'Thiên Thần Mù Sương kể về Minh Hà – bà mẹ một con nhút nhát và Hải Anh – bạn trai cũ của cô, một nghệ sĩ không được trọng dụng.\r\n\r\nCả hai bị ám ảnh bởi một chuyến xe ma quái mà họ đã tình cờ có mặt cách đó một tháng. Đó làchuyến xe đi lạc vào vùng sương mù dày đặc. Ở đó, họ nhìn thấy những người đã chết, những nỗi ám ảnh quá khứ hiện ra ngoài kính cửa. Một hành khách trên xe đã bị bắt cóc vào sương mù.\r\n\r\nCuộc sống của Minh Hà bị đảo lộn một cách lạ lùng sau chuyến xe, đến mức cô phải rời bỏ gia đình. Cô tái hợp với Hải Anh, lần tìm thông tin về sự kiện quái dị hôm trước, bắt đầu từ người hành khách mất tích. Thế nhưng, càng dấn sâu vào hành trình điều tra, họ càng lần ra những cái chết không manh mối, như trêu ngươi hai thám tử nghiệp dư.\r\n\r\nĐể rồi chính họ cũng sập bẫy, không thể quay đầu. Một thế giới khác vén màn,đảo ngược tất cả những gì họ từng biết về cuộc sống của mình.\r\nĐó là một ảo giác tập thể? Hay còn là một điều gì khác mà trí tuệ hạn hẹp của chúng ta chưa hề biết đến, một cánh cửa mở ra bí mật tận cùng của đời sống?', 2),
(5, 'THẢM KỊCH VĨ NHÂN', 105300, 'https://newshop.vn/public/uploads/products/23196/tham-kich-vi-nhan.jpg', 'Gần 600 năm trước, khi cuộc chiến chống ngoại bang kết thúc, cũng là lúc cuộc chiến phe cánh trong nội bộ triều đình nhà Lê mở ra. Trong cơn khủng hoảng đó, Nguyễn Trãi trở thành nạn nhân hứng chịu tấn thảm kịch oan khiên nhất, dã man nhất lịch sử nước Việt, mang tên Thảm kịch vĩ nhân.\r\n\r\nToàn bộ câu chuyện được kể lại xảy ra vỏn vẹn trong 27 ngày, từ ngày sinh Hoàng tử Lê Tư Thành (vua Lê Thánh Tông sau này), đến ngày Ức Trai Nguyễn Trãi và Lễ nghi học sĩ Nguyễn Thị Lộ cùng ba họ lên đoạn đầu đài. Vén bỏ bức màn hắc ám chốn thâm cung, nhà văn Hoàng Minh Tườngdẫn dụ người đọc lần theo những tình tiết ly kỳ, bóc tách những dấu vết mờ nhòe của lịch sử nhằm phơi bày màn kịch tội ác đã được dựng lên để sát hại một bậc vĩ nhân như Nguyễn Trãi.\r\n\r\nThảm kịch vĩ nhân không chỉ là câu chuyện của một cá nhân Nguyễn Trãi, đó còn là câu chuyện về người trí thức trong mối quan hệ với quyền lực, với dân tộc, với lẽ phải và lý tưởng mà họ theo đuổi. Tư cách người trí thức trước giông bão thời đại, chẳng phải là điều cốt lõi của một vĩ nhân sao! ', 2),
(6, 'CHUỘC TỘI', 97000, 'https://newshop.vn/public/uploads/products/23080/minato.jpg', 'Gửi cô Asako,\r\n\r\nCảm ơn cô vì hôm trước đã tới dự đám cưới của cháu.\r\n\r\nSuốt buổi lễ, cháu đã luôn lo rằng khi nhìn những người họ hàng cháu rồng rắn kéo nhau từ thị trấn thôn quê đó lên, cô sẽ nhớ lại sự việc khi ấy để rồi cảm thấy không thoải mái. Bởi đám người đó chẳng hề nhận ra cử chỉ và hành động của mình thiếu tế nhị tới chừng nào.\r\n\r\nKhông khí trong lành. Lần đầu tiên cháu nhận ra rằng, ngoại trừ điều đó, thị trấn ấy chẳng còn gì đáng kể là vào khoảng bảy năm trước, khi cháu tốt nghiệp cấp ba và lên Tokyo theo học trường đại học nữ sinh.\r\n\r\nBốn năm trời cháu sống trong ký túc xá của trường. Lúc cháu nói với bố mẹ rằng mình muốn lên Tokyo học đại học, bố mẹ cháu đều đồng thanh phản đối.\r\n\r\nLỡ con bị kẻ xấu lừa, bắt làm công việc bán thân thì phải làm sao? Rồi bị lôi kéo vào con đường nghiện ngập thì phải làm thế nào? Bố mẹ biết làm gì nếu con bị người ta sát hại?\r\n\r\nMột người sinh trưởng nơi đô thành như cô Asako đọc đến đây chắc sẽ phì cười mà nghĩ, rốt cuộc bố mẹ cháu nghe thông tin ở đâu mà lại có những lo lắng kỳ cục như vậy nhỉ.\r\n\r\nCháu đã mang chương trình yêu thích của bố mẹ ra mà cãi lại, rằng, “Đấy là tại bố mẹ xem chương trình Hai tư giờ ở đô thị lớn nhiều quá đó thôi”, dù thực ra cháu cũng nhiều lần tưởng tượng tới những chuyện đáng sợ như thế rồi. Dẫu vậy, cháu vẫn rất khát khao được lên Tokyo học.\r\n\r\n“Trên Tokyo có gì hay đâu? Ngành mà con muốn theo học, mấy trường đại học trong tỉnh mình cũng có. Nếu là các trường đó, thì tuy không thể đi về trong ngày, nhưng giá nhà trọ rẻ, gặp chuyện gì cũng có thể về nhà ngay được. Như vậy cả con và bố mẹ đều an tâm.”\r\nBố cháu đã thuyết phục cháu như vậy.\r\n\r\n“Sao bố mẹ có thể an tâm được? Không phải bố mẹ chính là những người hiểu rõ nhất, rằng khoảng tám năm trở lại đây, con đã sống trong sợ hãi ở thị trấn này như thế nào hay sao?”\r\n\r\nThấy cháu nói vậy, bố mẹ không phản đối nữa. Nhưng bố mẹ cháu ra một điều kiện là, khi lên đó thay vì sống một mình ở phòng trọ hay căn hộ chung cư, cháu phải vào sống trong ký túc xá dành cho sinh viên. Cháu không có ý kiến gì về việc đó.', 2),
(7, 'VÕ LUYỆN ĐỈNH PHONG', 104000, 'https://nghetruyenma.net/wp-content/uploads/2020/10/vo-luyen-dien-phong.jpg', 'Trời tờ mờ sáng, Dương Khai tựu tỉnh, hơi chút rửa mặt một phen liền cầm cạnh góc tường cái chổi đi ra sống một mình phòng nhỏ.\r\n \r\n Đứng tại cửa ra vào duỗi lưng một cái, nhìn thoáng qua đường chân trời hiển hiện một vòng ngân bạch sắc, nhắm mắt tập trung tư tưởng suy nghĩ hưởng thụ lấy một lát an bình, lập tức mở mắt ra mảnh vải vũ động thủ bên trên cái chổi, vùi đầu thanh lý chạm mặt đất tro bụi cùng lá rụng.\r\n \r\n Một bộ Thanh y, mộc mạc sạch sẽ, lão thành y sắc không duyên cớ đem thiếu niên phụ trợ hư trường mấy tuổi. Dương Khai cái eo như ném lao thẳng tắp, mặc dù là tại làm lấy tầng dưới chót nhất sống, trên mặt thần sắc cũng cẩn thận tỉ mỉ. Động tác rất trọng ổn, nắm bắt cây chổi hai tay cũng không dùng bao nhiêu lực, thân thể thậm chí đều không nhiều lắm đong đưa, chỉ bằng bắt tay vào làm cổ tay chuyển động, cái kia cây chổi liền dễ sai khiến, du đến hồ đi, theo hắn bộ pháp di động, trên mặt đất tích góp từng tí một tro bụi cùng vật lẫn lộn thần kỳ theo sát động , phảng phất không duyên cớ trường hai cái đùi.\r\n \r\n Dương Khai là Lăng Tiêu Các Thí Luyện đệ tử, ba năm trước đây tiến tông môn khai thủy tu luyện, có thể cho tới hôm nay cũng chỉ tu luyện tới Tôi Thể tầng ba cảnh giới. Cùng hắn cùng nhau Nhập Môn các sư huynh đệ đã sớm vượt xa giai đoạn này, tất cả được cơ duyên bái nhập trong môn cao nhân tọa hạ thăng chức rất nhanh đi, hắn lại chỉ có thể lực bất tòng tâm.\r\n \r\n Ba năm Tôi Thể tầng ba, bực này tư chất đã không phải là dùng bình thường hai chữ có thể hình dung được rồi, quả thực có thể nói là bình thường đến cực điểm.\r\n \r\n Không làm sao được, Dương Khai chỉ có thể ở trong tông môn tiếp cái quét rác sống, một bên duy trì sinh kế một bên đau khổ tu luyện.\r\n \r\n Lăng Tiêu Các là cái so sánh đặc thù môn phái, cái này đặc thù thể hiện môn hạ đệ tử cạnh tranh tàn khốc lên, tại môn phái này nội, người có năng lực thượng vị, không có năng lực người đào thải, mạnh được yếu thua cái này luật thép tại Lăng Tiêu Các nội bị diễn dịch phát huy vô cùng tinh tế.\r\n \r\n Những thứ khác tông môn có lẽ còn có chút đồng môn tình bạn tay chân tình nghĩa, nhưng là tại Lăng Tiêu Các nội không có! Muốn đi bên trên bò, chỉ có giẫm phải những cái kia cái gọi là các sư huynh đệ bả vai, bước qua máu tươi của bọn hắn, như thế mới có tư cách.', 1),
(8, 'Luân Hồi Lạc Viên ', 249000, 'https://www.nae.vn/ttv/ttv/public/images/story/99d2aa117de6f54b06b64cbbebef2b435336977dfee71f2ee5766d48b31734f3.jpg', 'Top 1 đồng nhân Qidian hiện tại. Mặc dù nói là đồng nhân nhưng xen lẫn trong đồng nhân(Diễn sinh thế giới) thì còn các Nguyên sinh thế giới(tác giả tự nghĩ) cùng Hư Không(đại map xuyên suốt truyện). Đến chục quyển gần đây chủ yếu chinh chiến Nguyên sinh thế giới, tất cả đều được liệt kê ở trên.\r\n\r\nCho đến chương hiện tại thì tính cách các nhận vật vẫn được xây dựng khá ổn, main thuộc trận doanh trung lập tà ác, lúc đánh ít dài dòng, IQ ổn, suy luận bày mưu tốt, main không giết lung tung mà ai gây sự mới giết + giết hết không tha kể cả nữ (rất hợp ý ta, main chưa có gái và khả năng rất cao là ko có luôn nên đừng mong gì về khoản này).\r\n\r\nDàn nhân vật phụ IQ ổn, không cẩu huyết, khiêu khích main,... nvp đánh đấm dùng não khá tốt. Main độc hành nhưng cũng kết bạn và có vài mối làm ăn, không phải tham lam điên cuồng hay thấy lợi là giết. Main có dàn pet đi theo rất hữu dụng và cực tấu hài.\r\n\r\nTác giả miêu tả PK tốt, main biết vận dụng thế lực trong từng thế giới, truyện có bối cảnh lớn và cực nhiều map, tất nhiên vẫn có những tình tiết hài, không khô khan tí nào. Hệ thống Nhạc Viên (Chủ Thần) trong truyện được xây dựng hợp lý, công bằng, thành tích cao thì nhiều quyền lợi và ngược lại, phá hoại hệ thống hoặc ảnh hưởng mục đích của Nhạc Viên (chế tạo cường giả) thì sẽ phái những người như main dùng \'Thân thiết\' phương thức nói cho đối phương biết, giờ chết của ngươi đến rồi.', 1),
(9, 'POKÉMON ', 452000, 'https://www.nae.vn/ttv/ttv/public/images/story/21252c34b8e5b4bc9b60344be8c409c59ac161338a55f9fc51dfed9d16f1f80e.jpg', 'Năm 2016 ngày mùng 9 tháng 6, hạ.\r\n\r\n	Trời trong gió nhẹ, vạn dặm không mây.\r\n\r\n	Nhưng nằm ở trên giường nằm ngáy o o Phương Duyên lại đột nhiên cảm giác thân thể mát lạnh.\r\n\r\n	\"Luôn cảm thấy quên chút gì. . .\"\r\n\r\n	Mở to mắt về sau, Phương Duyên nhìn lên trần nhà, vuốt vuốt đầu.\r\n\r\n	Là!\r\n\r\n	Hôm nay là thi đại học ngày, mà lại là thi đại học ngày cuối cùng.\r\n\r\n	Duỗi tay cầm điện thoại di động lên nhìn thoáng qua thời gian, Phương Duyên lập tức giật mình, giữa trưa ? !\r\n\r\n	\"Chuông báo không có vang à. . .\"\r\n\r\n	Hốt hoảng đưa di động sau khi để xuống, Phương Duyên trong lòng hơi hồi hộp một chút, nguy rồi, ngay tại hôm qua, hắn cùng ngay tại kinh lịch thi đại học học tỷ đã hẹn hôm nay muốn đi vì đối phương cố lên. . . Kết quả. . . Kết quả dậy trễ ?\r\n\r\n	Theo lý thuyết tối hôm qua hắn rất sớm đã Rest\\ngủ, coi như chuông báo không có vang cũng không trở thành ngủ đến giữa trưa đi.\r\n\r\n	Lần nữa đưa di động cầm lấy, Phương Duyên tâm tình hỏng bét vô cùng, lo lắng lấy nên như thế nào cùng học tỷ xin lỗi.\r\n\r\n	Bất quá. . .\r\n\r\n	Đinh!\r\n\r\n	Đúng lúc này, hệ thống bắn ra tới một tin tức khung.\r\n\r\n	Học tỷ: Buổi sáng đối chiến khảo thí rất thuận lợi, đối thủ Pikachu quá yếu.\r\n\r\n	\"Ha ha, xem ra kết quả không tệ.\"\r\n\r\n	Phương Duyên vừa định về một câu chúc mừng, thuận tiện nói lời xin lỗi, không quá mạnh nhưng ở giữa, hắn lại cảm thấy chỗ nào không thích hợp.\r\n\r\n	Đối chiến khảo thí ?\r\n\r\n	Pikachu ?\r\n\r\n	Ngươi không phải đi thi tốt nghiệp trung học sao, ngươi cho rằng ngươi đang chơi Pokémon a!\r\n\r\n	\"Ta nhất định còn chưa tỉnh ngủ.\"\r\n\r\n	Lúc này. . . Lại song nhược chuyết một đống tin tức khung bắn ra ngoài, là QQ tin tức.\r\n\r\n	Cái thứ nhất tin tức tiêu đề, liền rất không thể tưởng tượng, Phương Duyên nhìn lướt qua, toàn thân trên dưới càng không được tự nhiên.\r\n\r\n	« bốn tên chức nghiệp Trainer cộng tham Liêu Tây đại hạp cốc bí cảnh, tao ngộ thời kỳ viễn cổ hung mãnh Pokémon Aerodactyl, chỉ có một người còn sống! »\r\n\r\n	Phương Duyên nhíu mày lật ra bình luận.\r\n\r\n	Ngày sau hãy nói: Dực Long ? Long ? Lại phát hiện loại sản phẩm mới hệ Dragon Pokémon sao ?\r\n\r\n	Lớn cúc làm trọng: Xem ra Liêu Tây một vùng muốn náo nhiệt lên, ai muốn thu phục cái này Aerodactyl, nhất định có thể nổi danh, bất quá ngay cả bốn tên chức nghiệp Trainer cũng không là đối thủ, cái này Aerodactyl thực lực khẳng định không tầm thường.', 1),
(10, 'Song trùng', 245111, 'https://gacsach.com/sites/gacsach.com/files/styles/large/public/images/26761/172184632_2179344152198784_214163847867767093_n.jpg?itok=wXejfB97', 'Đêm nay, tôi đã mơ về cái chết của mình.\r\nMột kẻ cô độc trong màn đêm tối tăm lạnh lẽo. Thăm thăm. Hun hút. Mông lung. Tôi đứng lọt thỏm và mắc kẹt nơi bóng tối bủa vây. Những thanh âm sắc lạnh như chực chờ nuốt chửng.\r\n“Liệu khi chết đi rồi, người ta có được giải thoát không nhỉ?” Kim vẫn thường hỏi tôi như thế. “Có thể.” Tôi chưa bao giờ có một sự hình dung nguyên vẹn đối với cái chết. Với tôi, đó là những dòng ý thức đứt đoạn không có một sợi dây liên kết rõ ràng. Chết là hết. Hoặc giả chết là con đường để bước sang một thế giới khác. Cũng như nhau cả thôi. Nếu như dùng một cách ngắn gọn nhất để lý giải thì đó là khi sóng não của người ta ngừng hoạt động. Và con người thôi những suy nghĩ vớ vẩn, từ trên cao mà nhìn xuống cuộc đời với ánh mắt dửng dưng.”\r\nKim luôn có những ý nghĩ quái gở. Anh ta thường đi tìm kiếm những ý niệm về cái chết. Còn tôi, tôi quá bận rộn và chẳng có thời gian mà để tâm tới điều đó.\r\nThi thoảng mỗi khi Kim xuất hiện, những kí ức của cậu ta cũng theo đó mà thâm nhập vào bộ não của tôi. Kim không có quá nhiều những kí ức đẹp đẽ. Những mối liên hệ giữa cậu ta với thế giới bên ngoài chỉ xoay quanh hai tầng nhận thức vô cùng kì quặc. Đó là: Cái Chết và Nghệ Thuật.\r\nTôi lần theo những mảng kí ức của Kim. Có đôi lúc cậu ta sẽ mê mải rong chơi với những giai điệu du dương từ cây đàn vĩ cầm, thỏa bung những khát khao tự do bay bổng theo đôi cánh nghệ thuật. Lại có những lúc, cậu ta say sưa ngồi thì thầm khe khẽ theo những khuông nhạc, gõ gõ ngón tay theo từng nhịp phách ngân vang. Và sẽ có những lúc, cậu ta lặng lẽ ôm cây đàn rồi cúi mặt xuống mà khóc nức nở, đắm chìm trong nỗi tuyệt vọng u uẩn. Thật kì lạ! Tôi đã không thể nhớ ra nổi gương mặt của Kim. Cậu ta đến và ghé thăm tôi bất kì lúc nào rồi tan biến như một hình ảnh hư ảo trôi lãng đãng trong miền kí ức xa xôi.\r\n***\r\nTôi lặng lẽ ngắm nhìn mình trong gương. Phải rồi! Tôi chính là Kim. Đây là một trong những lần gặp gỡ tình cờ, hiếm hoi giữa tôi và gã. Tôi đã gặp bản sao của chính mình như trong câu chuyện truyền thuyết. Gã nhìn tôi. Cái nhìn vô hồn và trống rỗng. Dăm ba câu chuyện tầm phào, đôi lúc gã sẽ kể cho tôi nghe. Thi thoảng, tôi sẽ bắt gặp gã hướng ánh mắt lơ đãng nhìn ra ngoài cửa sổ. Chẳng hiểu nổi ngoài đó có gì mà thu hút gã đến thế. Âm thanh? Cảnh vật. Hay chỉ đơn giản đó là một thói quen. Đôi khi, gã cũng chẳng nói chẳng rằng, chỉ ngồi yên lặng mà lắng nghe những bản nhạc của tôi. Một kẻ biết khá rõ về tôi nhưng tôi lại không biết quá nhiều điều về gã.\r\nGã là một kẻ cầu toàn.Tôi đã sớm nhận ra điều đó. Trong những lần để vuột mất cơ hội để thăng chức, gã thở dài thườn thượt, ai oán cho cái số phận hẩm hiu. Rồi khi không có được những thứ như mong muốn, gã sẽ than vãn, tự trách móc bản thân mình vô dụng. Gã cũng là một người thích suy tính mọi việc theo lý trí. Có đôi khi, gã tỏ ra khinh thường tôi, một kẻ sẵn sàng sống theo bản năng và chạy theo những đam mê vụn vặt.', 2),
(11, 'Xóm Ế', 244000, 'https://cdn-4.ohay.tv/imgs/553723eeeb92485fbfe5/500.jpg', 'Đây là một câu chuyện mà ngoài đời bạn có thể bắt gặp được ở đâu đó hoặc được nghe ai đó kể lại.\r\n\r\nCác nhân vật của tôi cũng không phải hoàn toàn hư cấu, mà có thể bạn đã bắt gặp được bóng dáng họ ở đâu đấy ngoài đời thật.\r\n\r\nTôi chỉ là một người muốn truyền tải một thông điệp “Chiến tranh\" - Đó là thảm họa của loài người. Nó không chỉ gây bao mất mát, đau thương, tổn thất cho đất nước, cho những thế hệ sống trong thời kì đó mà còn ảnh hưởng đến cuộc sống của những thế hệ đi tiếp sau đó, hệ lụy biết bao con người. Vì vậy, ta còn sống trong hòa bình, hãy cố gắng bảo vệ hòa bình.\r\n\r\n**\r\n\r\nVào những năm đầu sau đổi mới…\r\n\r\nNhà nước tích cực thực hiện phong trào phổ cập giáo dục trên cả nước, phấn đấu chống lại giặc dốt.\r\n\r\nTại một làng quê heo hút, nằm cách xa thị trấn, hôm nay người ta dậy từ rất sớm chào đón một sự kiện tương đối đặc biệt. Họ kháo nhau rằng, hôm nay có một thầy giáo từ trên thị trấn tình nguyện chuyển về nơi đây dạy học.\r\n\r\nCòn vì sao lại là sự kiện đặc biệt thì đó là vì trong xóm bây giờ hiện tại chỉ có hai người là nam giới trên tổng số hai mươi hộ dân, nếu tính trung bình mỗi hộ dân chỉ có ba người, thì bạn đã thấy sự chênh lệch dân số ở đây như thế nào.\r\n\r\nCũng chính vì vậy, xóm này có một cái tên khá chua chát và dễ nhớ:\"Xóm ế\".\r\n\r\nPhần lớn hộ dân ở đây đều là những bà mẹ đơn thân, những cô gái đã quá lứa lỡ thì, một số ít còn lại là những người có chồng nhưng đã hi sinh trong chiến tranh.\r\n\r\nHọ không phải xấu xí, không phải dở hơi, đừng nghi ngờ mà mang tiếng họ.\r\n\r\nChỉ là, thời kì chiến tranh, trai làng đã xung phong ra chiến trường gần hết, hòa bình lập lại, những người con đó đều đã anh dũng ngã xuống, để lại một phần máu thịt của mình cho tổ quốc.\r\n\r\nXóm này chỉ còn lại đơn sơ, tan tác với những hậu quả của tàn dư chiến tranh.\r\n\r\nThầy giáo Văn theo lời chỉ dẫn của thầy hiệu trưởng chẳng khó mà tìm thấy \"Xóm ế\".\r\n\r\nTất nhiên, tên thật xóm này là xóm C, chỉ là dù có hỏi thế nào người ta vẫn chỉ nhớ đến cái tên \"Xóm ế\".\r\n\r\nChỉ cần đi qua đầu xóm thôi, thầy Văn đã thấy người ta chỉ chỉ trỏ trỏ, người người nhìn anh bằng con mắt hiếu kì, đi vào sâu chút nữa mới thấy có người hỏi to:\"Thầy giáo mới về đấy hả ?\". Anh chắp tay lễ phép:\"Vâng, chào cụ\".\r\n\r\nVào đến trường học, thầy hiệu trưởng niềm nở ra đón anh. Mái tóc ông đã bạc hết nửa. Ông mỉm cười vui vẻ, mang hành lí của anh đến chỗ ở mới.\r\n\r\n- Thầy giáo sẽ ở đây, còn dạy học ở gian bên kia nhé.\r\n\r\nÔng vừa nói dứt câu, đã thấy từ đàng xa có một cô gái chạy lại. Cô ta ôm một cái rổ, bên trong đựng đầy ổi chín, cô nàng cất giọng lanh lảnh từ đầu ngõ:\r\n\r\n- Bác Ba ơi, mẹ cháu bảo cháu mang ổi sang mời bác với thầy giáo mới.\r\n\r\nCô gái đó chỉ tầm độ mười tám đôi mươi, đang độ xuân sắc, liếc mắt nhìn thầy giáo mới, rồi tươi cười chào ra về.\r\n\r\nÔng hiệu trưởng lắc đầu cười. Thầy Văn còn ngơ ngác chưa hiểu tại sao.\r\n\r\nTối đến, đang thu dọn đồ đạc, anh lại thấy có người sang tìm: Lúc đầu, anh còn tưởng họ tìm ông Ba, nào ngờ tìm anh.\r\n\r\nLần này là người phụ nữ tầm ngoài ba mươi, cô ta chưa cần anh hỏi đã tự giới thiệu :\r\n\r\n- Chào thầy, tôi tên Cúc, nhà tôi ở đối diện trường này, hôm nay thấy thầy lặn lội đường xa đến đây thật cảm kích vô cùng nên tôi thay mặt người dân trong xóm sang hỏi thăm thầy.\r\n\r\n- Cảm ơn chị, có gì đâu, tôi tình nguyện về đây mong dạy cho các cháu cái chữ, để các cháu sau này nên người. Đây cũng là việc nên làm mà.\r\n\r\nChị ta mỉm cười nhìn thầy giáo, cố ý lại gần giường thầy ngồi, hỏi:\r\n\r\n- Thầy có cần tôi giúp gì không ?\r\n\r\n- Không cần đâu chị ạ.\r\n\r\n- Nếu cần gì cứ nói nhé, nhà tôi ở bên kia kìa.\r\n\r\nChị ta chỉ tay về phía đối diện cổng trường, trong khi thầy giáo đang mải tập trung dọn đồ, dường như chẳng nghe thấy những gì chị ta vừa nói.\r\n\r\n- Thầy này.\r\n\r\n- Dạ vâng,\r\n\r\n- Buổi tối tôi thường ở nhà một mình, nếu hôm nào thầy có rảnh thì sang chơi.\r\n\r\n- Vâng.', 2),
(12, 'Mối tình đầu', 234000, 'https://gacsach.com/sites/gacsach.com/files/styles/large/public/images/155760/moi_tinh_dau.png?itok=06oaTb89', 'Lặng lẽ nhìn rồi lặng lẽ quay đi vì sợ bắt gặp, cảm giác đó gọi là gì nhỉ? Nhìn trộm à? Mà thật ra cũng không hẳn là nhìn trộm mà chỉ là cái nhìn yêu thương của cô gái khẽ trao cho người mình thích nhưng lại sợ anh chàng kia biết mà thôi. Bạn đã bao giờ có cảm giác đó chưa? Còn với tôi chẳng biết từ khi nào mà tôi cứ lén la lén lút nhìn nó như thế.\r\n\r\n Nó chẳng có gì đặc biệt- một thằng con trai như  bao thằng con trai khác, cao, hơi ốm, nước da ngăm ngăm và nụ cười ấm áp. Nó đối với tôi có một xúc cảm đặc biệt đến lạ lùng. Mỗi lần vô tình chạm mặt nó tôi đều rất ngượng ngùng nhưng số phận thật biết trêu ngươi, chúng tôi học chung một lớp nên ngày nào cũng gặp nha. Từ lần gặp đầu tiên đầy bỡ ngỡ cho đến khi thành đôi bạn thân thiết, tôi chợt nhận ra rằng trái tim mình có chút xao xuyến, có chút rung động tuổi mới lớn. Tất cả diễn ra một cách tự nhiên và tinh tế, diệu kì như một bài thơ mà chất liệu từ những xúc cảm tưởng chừng mong manh nhất. Tình yêu là vậy đấy bao giờ cũng bắt đầu từ những điều nhỏ nhất, đơn giản nhất cho đến những điều cao quý nhất. Những lần không thuộc bài hai đứa vẫn “đồng cam cộng khổ” với nhau để vượt qua kì kiểm tra. Nhớ nhất là khi cô giáo bất ngờ tiến lại gần phía chúng tôi, vì sợ bị bắt gặp trao đổi bài giờ kiểm tra cả hai vô cùng lúng túng, những lúc như thế nhìn mặt nó đỏ ửng như quả cà chua chín quá  trông thật đáng yêu. Chẳng hiểu vì sao mà lúc nó đi, nó đứng, nó trò chuyện tôi đều để ý và mỗi lúc như thế tôi lại thấy nó càng đặc biệt hơn.\r\n\r\nVào những buổi tan trường cơn mưa chiều miền trung như trút nước, hai đứa đứng cùng nhau dưới hiên ngắm từng hạt mưa rơi rồi đưa bàn tay nhỏ bé của mình nghịch những giọt nước đang rơi vô định, trao nhau nụ cười ngây thơ tuổi học trò. Nó đã kể cho tôi nghe rất nhiều về bố, về mẹ và về nó nữa. Tôi chợt nhận ra giữa hai đứa có thật nhiều điểm chung và điểm chung lớn nhất là chỉ có một mình. Bất giác tâm hồn tôi cô đơn, trống rỗng, lòng mình như thắt lại, có một cơn đau chợt nhói lên trong tim rồi tan biết nhanh. Dường như đây chưa phải là lúc tôi cảm nhận được đầy đủ cơn đau đó vì rằng ít nhất tôi vẫn còn có bố, mẹ và… có nó. Tôi hiểu nó buồn như thế nào mỗi khi bố mẹ về muộn, bố mẹ cãi nhau hay họ bận rộn không quan tâm đến nó. Cô đơn là một cảm giác rất đáng sợ. Nó không làm ta tổn thương thể xác nhưng để lại những vết thương lòng dai dẳng không nguôi. Tôi đã từng cảm thấy rất cô đơn khi không có anh chị em, khi thấy bạn nào đó được chị mình dắt đi hoc hay đi ra phố mua quà sinh nhật. Tôi và nó hai đứa trẻ như hai tâm hồn đơn điệu bỗng vô tình gặp nhau, mang đến cho nhau những phút trải lòng, những kỉ niệm vui dù chỉ là thoáng qua.\r\n\r\nNgày tháng cứ thế lặng lẽ trôi, chúng tôi đã lớn lên cạnh nhau và tình yêu trong tôi cũng theo đó lớn dần, biết ghen tuông, biết giận hờn. Có một chút tức giận khi thấy nó trò chuyện vui vẻ với một đứa con gái nào đó trong lớp mà trong cuộc trò chuyện đó không có tôi. Có một chút buồn bồn chồn, lo lắng khi nó ốm nghỉ học mấy ngày không gặp? Dẫu vẫn biết tình đầu mong manh dễ vỡ nhưng sao trong tim tôi vẫn cố gắng tìm kiếm một tình đầu như thế- một tình đầu lung linh như thủy tinh dưới nắng. Phải chăng trái tim tuổi mới lớn thường bồng bột, ngây thơ là thế? Cố giấu cảm xúc tôi đã làm như thế trong khi rất muốn nói ra những gì trái tim mách bảo. Tôi đã lặng lẽ yêu rồi lặng lẽ nhìn nó ra khỏi cuộc đời mình.\r\n\r\nNó theo gia đình sang Mỹ định cư, còn tôi vẫn ở lại với thị trấn thân thương với biết bao những kỉ niệm vui buồn. Khi biết nó sắp đi tôi buồn lắm nhưng tôi đâu thể làm gì khác. Nếu định mệnh đã cho chúng tôi gặp nhau nhưng không để chúng tôi bên nhau thì tôi cũng chỉ có thể im lặng mỉm cười mà bước tiếp. Đường đời rộng lớn biết đâu được một ngày nào đó những con đường lại giao nhau và kí ức xưa sống lại lần nữa.\r\n\r\nDù thời gian trôi qua đã khá lâu kể từ ngày chiếc máy bay cất cánh mang nó đến một nơi xa lạ cách tôi nửa vòng trái đất, chúng tôi vẫn chưa một lần gặp lại. Phải chăng đây là ý trời. Tôi và nó mỗi đứa có một đường đi riêng, một định hướng riêng. Nhưng đôi khi ngẫm lại những chuyện xưa ký ức ngày nào lại hiện về trong tôi như vẫn còn tươi nguyên. Tôi tự nhủ hãy khép lại ký ức một thời vì nó đã là quá khứ. Cái gì đến sẽ đến, cái gì đi sẽ đi nhưng sao trong lòng tôi vẫn băn khoăn một câu hỏi không lời giải: Nếu như ngày đó mình dũng cảm nói ra tấm chân tình thì liệu giờ này mọi thứ có khác hơn không?', 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(200) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `password`) VALUES
(1, 'bui van sy', 'bvsy@gmail.com', '1'),
(2, '1', '1', '1'),
(3, 'Bui Van Sy', 'bvsy1@gmail.com', '1'),
(4, 'Bui Van Sy', 'bvsy@mail.co', '1'),
(5, 'Pham Van Thien', 'pvthien@gmail.cm', '1'),
(6, 'Pham Van Thien', 'pvthien@gmail.cm', '1'),
(7, 'Pham Van Thien', 'pvthien@gmail.com', '1');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `chitietdonhang`
--
ALTER TABLE `chitietdonhang`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `donhang`
--
ALTER TABLE `donhang`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `loaisanpham`
--
ALTER TABLE `loaisanpham`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `chitietdonhang`
--
ALTER TABLE `chitietdonhang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `donhang`
--
ALTER TABLE `donhang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT cho bảng `loaisanpham`
--
ALTER TABLE `loaisanpham`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT cho bảng `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
