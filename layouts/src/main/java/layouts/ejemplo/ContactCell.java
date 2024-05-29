package layouts.ejemplo;

import javafx.geometry.Pos;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class ContactCell extends ListCell<Contact> {
    private HBox content;
    private Text name;
    private ImageView imageView;

    public ContactCell() {
        super();
        name = new Text();
        imageView = new ImageView();
        imageView.setFitHeight(40);
        imageView.setFitWidth(40);
        content = new HBox(10, imageView, name);
        content.setAlignment(Pos.CENTER_LEFT);
    }

    @Override
    protected void updateItem(Contact contact, boolean empty) {
        super.updateItem(contact, empty);
        if (contact != null && !empty) {
            name.setText(contact.getName());
            imageView.setImage(contact.getImage());
            setGraphic(content);
        } else {
            setGraphic(null);
        }
    }
}
