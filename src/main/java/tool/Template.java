package tool;

public class Template {

    public static String getOrderHtml() {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>CheckCart</title>\n" +
                "  <style>\n" +
                "    body{\n" +
                "    width: 630px;\n" +
                "    height: 100vh;\n" +
                "    margin: 0 auto;\n" +
                "}\n" +
                "\n" +
                ".wrapper{\n" +
                "    background-color: #cccbc9;\n" +
                "    margin-top: 70px;\n" +
                "    border-radius: 5px;\n" +
                "    box-shadow: 10px 10px 5px #888888;\n" +
                "}\n" +
                "\n" +
                ".title-email{\n" +
                "    text-align: center;\n" +
                "    padding-top: 10px;\n" +
                "    border-bottom: 2.5px solid #e06d6d;\n" +
                "}\n" +
                "\n" +
                ".container-main{\n" +
                "    margin: 5px 90px;\n" +
                "    background-color: white;\n" +
                "    margin: 25px; \n" +
                "}\n" +
                "\n" +
                ".content{\n" +
                "    display: flex;\n" +
                "    justify-content: center;\n" +
                "    font-size: 20px;\n" +
                "    font-family: monospace;\n" +
                "    position: relative;\n" +
                "    border-radius: 20px; /* Độ cong của góc */\n" +
                "    background-color: #fff; /* Màu nền trắng */\n" +
                "    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Đổ bóng */\n" +
                "    margin: 25px; /* Khoảng cách giữa nội dung và viền */\n" +
                "}\n" +
                "\n" +
                ".fa-hand {\n" +
                "    position: absolute;\n" +
                "    top: 50%; \n" +
                "    left: 60%; \n" +
                "    transform: translate(-50%, -50%); \n" +
                "  }\n" +
                "\n" +
                "  .textField {\n" +
                "    color: rgb(30, 177, 128);\n" +
                "    font-size: 24px; /* Kích thước chữ cho .textField */\n" +
                "    font-weight: bold; /* Chữ in đậm cho .textField */\n" +
                "    padding: 10px; /* Khoảng cách dưới cho .textField */\n" +
                "  }\n" +
                "\n" +
                "  .id-key {\n" +
                "    font-size: 16px; /* Kích thước chữ cho .id-key */\n" +
                "    color: #555; /* Màu chữ cho .id-key */\n" +
                "    padding-left: 10px;\n" +
                "  }\n" +
                "\n" +
                "\n" +
                ".footer {\n" +
                "    background-color: #333; /* Màu nền cho footer */\n" +
                "    color: #fff; /* Màu chữ cho footer */\n" +
                "    text-align: center;\n" +
                "    padding: 20px;\n" +
                "  }\n" +
                "  \n" +
                "  .footer a {\n" +
                "    color: #fff; /* Màu chữ cho các liên kết trong footer */\n" +
                "    text-decoration: none;\n" +
                "    font-weight: bold;\n" +
                "  }\n" +
                "  \n" +
                "  .footer a:hover {\n" +
                "    text-decoration: underline; /* Hiệu ứng gạch chân khi di chuột qua liên kết */\n" +
                "  }\n" +
                "  </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"wrapper\">\n" +
                "        <div class=\"title-email\">\n" +
                "        <div class=\"container-main\">\n" +
                "            <div class=\"textField\">Thông báo đơn hàng được đặt thành công</div> \n" +
                "            <p class=\"id-key\">TrueMart cảm ơn quý khách đã tin tưởng và sử dụng sản phẩm của chúng tôi!</p>   \n" +
                "           \n" +
                "        </div>\n" +
                "        <div class=\"footer\">\n" +
                "            <p>Trang Bán Hàng 2023 <span><a href=\"\">TrueMart. </a></span>All Rights Reserved.\n" +
                "            </p>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</body>\n" +
                "</html>";
    }

    public static String getKeyHtml(String key) {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Document</title>\n" +
                "    <style>\n" +
                "      body{\n" +
                "    width: 630px;\n" +
                "    height: 100vh;\n" +
                "    margin: 0 auto;\n" +
                "}\n" +
                "\n" +
                ".wrapper{\n" +
                "    background-color: #cccbc9;\n" +
                "    margin-top: 70px;\n" +
                "    border-radius: 5px;\n" +
                "    box-shadow: 10px 10px 5px #888888;\n" +
                "}\n" +
                "\n" +
                ".title-email{\n" +
                "    text-align: center;\n" +
                "    padding-top: 10px;\n" +
                "    border-bottom: 2.5px solid #e06d6d;\n" +
                "}\n" +
                "\n" +
                ".container-main{\n" +
                "    margin: 5px 90px;\n" +
                "    background-color: white;\n" +
                "    margin: 25px; /* Khoảng cách giữa nội dung và viền */\n" +
                "}\n" +
                "\n" +
                ".container-top{\n" +
                "    \n" +
                "}\n" +
                "\n" +
                ".content{\n" +
                "    display: flex;\n" +
                "    justify-content: center;\n" +
                "    font-size: 20px;\n" +
                "    font-family: monospace;\n" +
                "    position: relative;\n" +
                "    border-radius: 20px; /* Độ cong của góc */\n" +
                "    background-color: #fff; /* Màu nền trắng */\n" +
                "    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Đổ bóng */\n" +
                "    margin: 25px; /* Khoảng cách giữa nội dung và viền */\n" +
                "\n" +
                "\n" +
                "}\n" +
                "\n" +
                ".fa-hand {\n" +
                "    position: absolute;\n" +
                "    top: 50%; \n" +
                "    left: 60%; \n" +
                "    transform: translate(-50%, -50%); \n" +
                "  }\n" +
                "\n" +
                ".container-main{\n" +
                "    border-radius: 1.5px;\n" +
                "    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Đổ bóng */\n" +
                "    text-align: center; \n" +
                "    /* width: 450px; */\n" +
                "}\n" +
                "\n" +
                ".textField {\n" +
                "    color: rgb(30, 177, 128);\n" +
                "    font-size: 24px; /* Kích thước chữ cho .textField */\n" +
                "    font-weight: bold; /* Chữ in đậm cho .textField */\n" +
                "    padding: 10px; /* Khoảng cách dưới cho .textField */\n" +
                "  }\n" +
                "\n" +
                "  .container-key {\n" +
                "    text-align: center;\n" +
                "    padding: 20px;\n" +
                "    background-color: #f5f5f5; \n" +
                "  }\n" +
                "  \n" +
                "  label {\n" +
                "    display: block;\n" +
                "    font-size: 18px;\n" +
                "    margin-bottom: 8px;\n" +
                "    color: #333;\n" +
                "  }\n" +
                "  \n" +
                "  input[type=\"text\"] {\n" +
                "    width: 100%;\n" +
                "    padding: 10px;\n" +
                "    font-size: 16px;\n" +
                "    border: 1px solid #ccc;\n" +
                "    border-radius: 4px;\n" +
                "    box-sizing: border-box;\n" +
                "    color: #555;\n" +
                "  }\n" +
                "  \n" +
                "  .id-key {\n" +
                "    font-size: 16px; /* Kích thước chữ cho .id-key */\n" +
                "    color: #555; /* Màu chữ cho .id-key */\n" +
                "  }\n" +
                "\n" +
                "  button {\n" +
                "    padding: 10px 20px; /* Kích thước nút */\n" +
                "    font-size: 16px; /* Kích thước chữ */\n" +
                "    cursor: pointer;\n" +
                "    border: none;\n" +
                "    border-radius: 5px; /* Bo tròn mép nút */\n" +
                "}\n" +
                "\n" +
                "/* Màu nền và màu chữ */\n" +
                "button {\n" +
                "    background-color: #e62e04; /* Màu nền xanh lá cây */\n" +
                "    color: white; /* Màu chữ trắng */\n" +
                "    margin: 10px 20px; \n" +
                "}\n" +
                "\n" +
                "/* Hover effect */\n" +
                "button:hover {\n" +
                "    background-color: #e77573; /* Màu nền khi di chuột vào nút */\n" +
                "}\n" +
                "\n" +
                "/* Active effect */\n" +
                "button:active {\n" +
                "    background-color: #e77573; /* Màu nền khi nút được nhấn */\n" +
                "}\n" +
                "\n" +
                "  .footer {\n" +
                "    background-color: #333; /* Màu nền cho footer */\n" +
                "    color: #fff; /* Màu chữ cho footer */\n" +
                "    text-align: center;\n" +
                "    padding: 20px;\n" +
                "  }\n" +
                "  \n" +
                "  .footer a {\n" +
                "    color: #fff; /* Màu chữ cho các liên kết trong footer */\n" +
                "    text-decoration: none;\n" +
                "    font-weight: bold;\n" +
                "  }\n" +
                "  \n" +
                "  .footer a:hover {\n" +
                "    text-decoration: underline; /* Hiệu ứng gạch chân khi di chuột qua liên kết */\n" +
                "  }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"wrapper\">\n" +
                "        <div class=\"title-email\">\n" +
                "        </div>\n" +
                "        <div class=\"container-main\">\n" +
                "            <div class=\"textField\">Đơn đăng ký tài khoảng thành công</div> \n" +
                "            <p class=\"id-key\"> Đây là mã key mới, vui lòng không cho bất kì ai biết được mã này!</p>   \n" +
                "            <p class=\"id-key\"> Mã này sẽ được dùng khi bạn đặt hàng ở cửa hàng của chúng tôi. Cảm ơn bạn đã đồng hàng cùng TrueMart!</p>   \n" +
                "            <div class=\"container-key\">\n" +
                "                <label for=\"publicKey\">Public Key:</label>\n" +
                "                <input type=\"text\" id=\"publicKey\" value=\""+key+"\" readonly>\n" +
                "                \n" +
                "              </div>\n" +
                "              <button onclick=\"copyToClipboard()\">Sao chép</button>\n" +
                "        </div>\n" +
                "        <div class=\"footer\">\n" +
                "            <p>Trang Bán Hàng 2023 <span><a href=\"\">TrueMart. </a></span>All Rights Reserved.\n" +
                "            </p>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "\n" +
                "    <script>\n" +
                "       function copyToClipboard() {\n" +
                "            /* Get the text field */\n" +
                "            var publicKeyField = document.getElementById(\"publicKey\");\n" +
                "\n" +
                "            /* Select the text field */\n" +
                "            publicKeyField.select();\n" +
                "            publicKeyField.setSelectionRange(0, 99999); /* For mobile devices */\n" +
                "\n" +
                "            /* Copy the text inside the text field */\n" +
                "            document.execCommand(\"copy\");\n" +
                "\n" +
                "            /* Alert the copied text */\n" +
                "            alert(\"Public Key copied: \" + publicKeyField.value);\n" +
                "        }\n" +
                "    </script>\n" +
                "    </script>\n" +
                "</body>\n" +
                "</html>";
    }

    public static String getReprotKeyHtml(String key) {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Document</title>\n" +
                "    <style>\n" +
                "      body{\n" +
                "    width: 630px;\n" +
                "    height: 100vh;\n" +
                "    margin: 0 auto;\n" +
                "}\n" +
                "\n" +
                ".wrapper{\n" +
                "    background-color: #cccbc9;\n" +
                "    margin-top: 70px;\n" +
                "    border-radius: 5px;\n" +
                "    box-shadow: 10px 10px 5px #888888;\n" +
                "}\n" +
                "\n" +
                ".title-email{\n" +
                "    text-align: center;\n" +
                "    padding-top: 10px;\n" +
                "    border-bottom: 2.5px solid #e06d6d;\n" +
                "}\n" +
                "\n" +
                ".container-main{\n" +
                "    margin: 5px 90px;\n" +
                "    background-color: white;\n" +
                "    margin: 25px; /* Khoảng cách giữa nội dung và viền */\n" +
                "}\n" +
                "\n" +
                ".container-top{\n" +
                "    \n" +
                "}\n" +
                "\n" +
                ".content{\n" +
                "    display: flex;\n" +
                "    justify-content: center;\n" +
                "    font-size: 20px;\n" +
                "    font-family: monospace;\n" +
                "    position: relative;\n" +
                "    border-radius: 20px; /* Độ cong của góc */\n" +
                "    background-color: #fff; /* Màu nền trắng */\n" +
                "    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Đổ bóng */\n" +
                "    margin: 25px; /* Khoảng cách giữa nội dung và viền */\n" +
                "\n" +
                "\n" +
                "}\n" +
                "\n" +
                ".fa-hand {\n" +
                "    position: absolute;\n" +
                "    top: 50%; \n" +
                "    left: 60%; \n" +
                "    transform: translate(-50%, -50%); \n" +
                "  }\n" +
                "\n" +
                ".container-main{\n" +
                "    border-radius: 1.5px;\n" +
                "    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Đổ bóng */\n" +
                "    text-align: center; \n" +
                "    /* width: 450px; */\n" +
                "}\n" +
                "\n" +
                ".textField {\n" +
                "    color: rgb(30, 177, 128);\n" +
                "    font-size: 24px; /* Kích thước chữ cho .textField */\n" +
                "    font-weight: bold; /* Chữ in đậm cho .textField */\n" +
                "    padding: 10px; /* Khoảng cách dưới cho .textField */\n" +
                "  }\n" +
                "\n" +
                "  .container-key {\n" +
                "    text-align: center;\n" +
                "    padding: 20px;\n" +
                "    background-color: #f5f5f5; \n" +
                "  }\n" +
                "  \n" +
                "  label {\n" +
                "    display: block;\n" +
                "    font-size: 18px;\n" +
                "    margin-bottom: 8px;\n" +
                "    color: #333;\n" +
                "  }\n" +
                "  \n" +
                "  input[type=\"text\"] {\n" +
                "    width: 100%;\n" +
                "    padding: 10px;\n" +
                "    font-size: 16px;\n" +
                "    border: 1px solid #ccc;\n" +
                "    border-radius: 4px;\n" +
                "    box-sizing: border-box;\n" +
                "    color: #555;\n" +
                "  }\n" +
                "  \n" +
                "  .id-key {\n" +
                "    font-size: 16px; /* Kích thước chữ cho .id-key */\n" +
                "    color: #555; /* Màu chữ cho .id-key */\n" +
                "  }\n" +
                "\n" +
                "  button {\n" +
                "    padding: 10px 20px; /* Kích thước nút */\n" +
                "    font-size: 16px; /* Kích thước chữ */\n" +
                "    cursor: pointer;\n" +
                "    border: none;\n" +
                "    border-radius: 5px; /* Bo tròn mép nút */\n" +
                "}\n" +
                "\n" +
                "/* Màu nền và màu chữ */\n" +
                "button {\n" +
                "    background-color: #e62e04; /* Màu nền xanh lá cây */\n" +
                "    color: white; /* Màu chữ trắng */\n" +
                "    margin: 10px 20px; \n" +
                "}\n" +
                "\n" +
                "/* Hover effect */\n" +
                "button:hover {\n" +
                "    background-color: #e77573; /* Màu nền khi di chuột vào nút */\n" +
                "}\n" +
                "\n" +
                "/* Active effect */\n" +
                "button:active {\n" +
                "    background-color: #e77573; /* Màu nền khi nút được nhấn */\n" +
                "}\n" +
                "\n" +
                "  .footer {\n" +
                "    background-color: #333; /* Màu nền cho footer */\n" +
                "    color: #fff; /* Màu chữ cho footer */\n" +
                "    text-align: center;\n" +
                "    padding: 20px;\n" +
                "  }\n" +
                "  \n" +
                "  .footer a {\n" +
                "    color: #fff; /* Màu chữ cho các liên kết trong footer */\n" +
                "    text-decoration: none;\n" +
                "    font-weight: bold;\n" +
                "  }\n" +
                "  \n" +
                "  .footer a:hover {\n" +
                "    text-decoration: underline; /* Hiệu ứng gạch chân khi di chuột qua liên kết */\n" +
                "  }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"wrapper\">\n" +
                "        <div class=\"title-email\">\n" +
                "        </div>\n" +
                "        <div class=\"container-main\">\n" +
                "            <div class=\"textField\">Tạo lại key</div> \n" +
                "            <p class=\"id-key\"> Đây là mã key mới, vui lòng không cho bất kì ai biết được mã này!</p>   \n" +
                "            <p class=\"id-key\"> Mã này sẽ được dùng khi bạn đặt hàng ở cửa hàng của chúng tôi. Cảm ơn bạn đã đồng hàng cùng TrueMart!</p>   \n" +
                "            <div class=\"container-key\">\n" +
                "                <label for=\"publicKey\">Public Key:</label>\n" +
                "                <input type=\"text\" id=\"publicKey\" value=\""+key+"\" readonly>\n" +
                "                \n" +
                "              </div>\n" +
                "              <button onclick=\"copyToClipboard()\">Sao chép</button>\n" +
                "        </div>\n" +
                "        <div class=\"footer\">\n" +
                "            <p>Trang Bán Hàng 2023 <span><a href=\"\">TrueMart. </a></span>All Rights Reserved.\n" +
                "            </p>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "\n" +
                "    <script>\n" +
                "       function copyToClipboard() {\n" +
                "            /* Get the text field */\n" +
                "            var publicKeyField = document.getElementById(\"publicKey\");\n" +
                "\n" +
                "            /* Select the text field */\n" +
                "            publicKeyField.select();\n" +
                "            publicKeyField.setSelectionRange(0, 99999); /* For mobile devices */\n" +
                "\n" +
                "            /* Copy the text inside the text field */\n" +
                "            document.execCommand(\"copy\");\n" +
                "\n" +
                "            /* Alert the copied text */\n" +
                "            alert(\"Public Key copied: \" + publicKeyField.value);\n" +
                "        }\n" +
                "    </script>\n" +
                "    </script>\n" +
                "</body>\n" +
                "</html>";
    }
    public static String getCancelOrderHtml() {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>CheckCart</title>\n" +
                "  <style>\n" +
                "    body{\n" +
                "    width: 630px;\n" +
                "    height: 100vh;\n" +
                "    margin: 0 auto;\n" +
                "}\n" +
                "\n" +
                ".wrapper{\n" +
                "    background-color: #cccbc9;\n" +
                "    margin-top: 70px;\n" +
                "    border-radius: 5px;\n" +
                "    box-shadow: 10px 10px 5px #888888;\n" +
                "}\n" +
                "\n" +
                ".title-email{\n" +
                "    text-align: center;\n" +
                "    padding-top: 10px;\n" +
                "    border-bottom: 2.5px solid #e06d6d;\n" +
                "}\n" +
                "\n" +
                ".container-main{\n" +
                "    margin: 5px 90px;\n" +
                "    background-color: white;\n" +
                "    margin: 25px; \n" +
                "}\n" +
                "\n" +
                ".content{\n" +
                "    display: flex;\n" +
                "    justify-content: center;\n" +
                "    font-size: 20px;\n" +
                "    font-family: monospace;\n" +
                "    position: relative;\n" +
                "    border-radius: 20px; /* Độ cong của góc */\n" +
                "    background-color: #fff; /* Màu nền trắng */\n" +
                "    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Đổ bóng */\n" +
                "    margin: 25px; /* Khoảng cách giữa nội dung và viền */\n" +
                "}\n" +
                "\n" +
                ".fa-hand {\n" +
                "    position: absolute;\n" +
                "    top: 50%; \n" +
                "    left: 60%; \n" +
                "    transform: translate(-50%, -50%); \n" +
                "  }\n" +
                "\n" +
                "  .textField {\n" +
                "    color: rgb(30, 177, 128);\n" +
                "    font-size: 24px; /* Kích thước chữ cho .textField */\n" +
                "    font-weight: bold; /* Chữ in đậm cho .textField */\n" +
                "    padding: 10px; /* Khoảng cách dưới cho .textField */\n" +
                "  }\n" +
                "\n" +
                "  .id-key {\n" +
                "    font-size: 16px; /* Kích thước chữ cho .id-key */\n" +
                "    color: #555; /* Màu chữ cho .id-key */\n" +
                "    padding-left: 10px;\n" +
                "  }\n" +
                "\n" +
                "\n" +
                ".footer {\n" +
                "    background-color: #333; /* Màu nền cho footer */\n" +
                "    color: #fff; /* Màu chữ cho footer */\n" +
                "    text-align: center;\n" +
                "    padding: 20px;\n" +
                "  }\n" +
                "  \n" +
                "  .footer a {\n" +
                "    color: #fff; /* Màu chữ cho các liên kết trong footer */\n" +
                "    text-decoration: none;\n" +
                "    font-weight: bold;\n" +
                "  }\n" +
                "  \n" +
                "  .footer a:hover {\n" +
                "    text-decoration: underline; /* Hiệu ứng gạch chân khi di chuột qua liên kết */\n" +
                "  }\n" +
                "  </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"wrapper\">\n" +
                "        <div class=\"title-email\">\n" +
                "        <div class=\"container-main\">\n" +
                "            <div class=\"textField\">Thông báo đơn hàng đã bị hủy</div> \n" +
                "            <p class=\"id-key\">\"Tôi rất tiếc khi phải thông báo rằng đơn hàng của bạn đã bị người khác chỉnh sửa thông tin, bạn có thể đặt hàng lại nhé!\"</p>   \n" +
                "           \n" +
                "        </div>\n" +
                "        <div class=\"footer\">\n" +
                "            <p>Trang Bán Hàng 2023 <span><a href=\"\">TrueMart. </a></span>All Rights Reserved.\n" +
                "            </p>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</body>\n" +
                "</html>";
    }
    public static String getExpiredKeyHtml(){
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>CheckCart</title>\n" +
                "  <style>\n" +
                "    body{\n" +
                "    width: 630px;\n" +
                "    height: 100vh;\n" +
                "    margin: 0 auto;\n" +
                "}\n" +
                "\n" +
                ".wrapper{\n" +
                "    background-color: #cccbc9;\n" +
                "    margin-top: 70px;\n" +
                "    border-radius: 5px;\n" +
                "    box-shadow: 10px 10px 5px #888888;\n" +
                "}\n" +
                "\n" +
                ".title-email{\n" +
                "    text-align: center;\n" +
                "    padding-top: 10px;\n" +
                "    border-bottom: 2.5px solid #e06d6d;\n" +
                "}\n" +
                "\n" +
                ".container-main{\n" +
                "    margin: 5px 90px;\n" +
                "    background-color: white;\n" +
                "    margin: 25px; \n" +
                "}\n" +
                "\n" +
                ".content{\n" +
                "    display: flex;\n" +
                "    justify-content: center;\n" +
                "    font-size: 20px;\n" +
                "    font-family: monospace;\n" +
                "    position: relative;\n" +
                "    border-radius: 20px; /* Độ cong của góc */\n" +
                "    background-color: #fff; /* Màu nền trắng */\n" +
                "    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Đổ bóng */\n" +
                "    margin: 25px; /* Khoảng cách giữa nội dung và viền */\n" +
                "}\n" +
                "\n" +
                ".fa-hand {\n" +
                "    position: absolute;\n" +
                "    top: 50%; \n" +
                "    left: 60%; \n" +
                "    transform: translate(-50%, -50%); \n" +
                "  }\n" +
                "\n" +
                "  .textField {\n" +
                "    color: rgb(30, 177, 128);\n" +
                "    font-size: 24px; /* Kích thước chữ cho .textField */\n" +
                "    font-weight: bold; /* Chữ in đậm cho .textField */\n" +
                "    padding: 10px; /* Khoảng cách dưới cho .textField */\n" +
                "  }\n" +
                "\n" +
                "  .id-key {\n" +
                "    font-size: 16px; /* Kích thước chữ cho .id-key */\n" +
                "    color: #555; /* Màu chữ cho .id-key */\n" +
                "    padding-left: 10px;\n" +
                "  }\n" +
                "\n" +
                "\n" +
                ".footer {\n" +
                "    background-color: #333; /* Màu nền cho footer */\n" +
                "    color: #fff; /* Màu chữ cho footer */\n" +
                "    text-align: center;\n" +
                "    padding: 20px;\n" +
                "  }\n" +
                "  \n" +
                "  .footer a {\n" +
                "    color: #fff; /* Màu chữ cho các liên kết trong footer */\n" +
                "    text-decoration: none;\n" +
                "    font-weight: bold;\n" +
                "  }\n" +
                "  \n" +
                "  .footer a:hover {\n" +
                "    text-decoration: underline; /* Hiệu ứng gạch chân khi di chuột qua liên kết */\n" +
                "  }\n" +
                "  </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"wrapper\">\n" +
                "        <div class=\"title-email\">\n" +
                "        <div class=\"container-top\">\n" +
                "            <div class=\"content\">\n" +
                "            </div>\n" +
                "        </div>\n" +
                "        <div class=\"container-main\">\n" +
                "            <div class=\"textField\">Cảm ơn bạn đã đặt hàng</div> \n" +
                "            <p class=\"id-key\">\"Tôi rất tiếc khi phải thông báo rằngn đơn hàng của bạn đã bị hủy do mã key của bạn đã hết hạn, bạn vui lòng tạo mã key mới!\"</p>   \n" +
                "           \n" +
                "        </div>\n" +
                "        <div class=\"footer\">\n" +
                "            <p>Trang Bán Hàng 2023 <span><a href=\"\">TrueMart. </a></span>All Rights Reserved.\n" +
                "            </p>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</body>\n" +
                "</html>";
    }

}
