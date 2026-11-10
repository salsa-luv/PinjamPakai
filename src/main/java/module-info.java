module com.mycompany.pinjampakai {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.pinjampakai to javafx.fxml;
    exports com.mycompany.pinjampakai;
}
