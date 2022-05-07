function loadMessages() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var messages = JSON.parse(this.responseText);
            var html = '';
            for (var i = 0; i < messages.length; i++) {
                var message = messages[i];
                html = html + '<a href="receivedMessages.html" class="message-button">\n' +
                    '<div class="sender-name">' + message.sendersMail.mailAddress + '</div>\n' +
                    '<div class="text-of-message">' + message.messageContent + '</div>\n' +
                    '<div>Сегодня</div>\n' +
                    '</a>';
                if (i < messages.length - 1) {
                    html = html + '<div><hr></div>'
                }
            }

            document.getElementById("received-count").innerText = messages.length;
            document.getElementById("messages").innerHTML = html;
        }
        if (this.status == 404) {
            html = '<div id="messages-not-found">Нет новых писем</div>\n' +
                '<style>\n' +
                '   #messages-not-found {\n' +
                '    font-size: 200%;\n' +
                '    font-family: "Montserrat";\n' +
                '    color: grey;\n' +
                '    text-align: center;' +
                '   }\n' +
                '  </style>';
            document.getElementById("messages").innerHTML = html;
        }
    };
    xhttp.open("GET", "http://localhost:8080/messages/byMailId/1", true);
    xhttp.send();

}

loadMessages();


