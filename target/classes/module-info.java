module com.mycompany.chatroom {
    requires javafx.controls;
    requires java.desktop;
    requires java.logging;
    exports com.mycompany.chatroom;
    requires miglayout.swing;
    requires java.sql;
    requires com.microsoft.sqlserver.jdbc;
    requires io.netty.all;
    requires socket.io.client;
    
}
