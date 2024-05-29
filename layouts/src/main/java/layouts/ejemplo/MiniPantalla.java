package layouts.ejemplo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MiniPantalla extends Application {

    private ListView<Contact> chatList;
    private TextArea chatArea;
    private TextField mensajeField;

    @Override
    public void start(@SuppressWarnings("exports") Stage primaryStage) {
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));

        // ListView para la lista de chats
        chatList = new ListView<>();
        chatList.getItems().addAll(
                new Contact("Chat 1", getClass().getResource("/layouts/ejemplo/imagenes/imagen1.png").toExternalForm()),
                new Contact("Chat 2", getClass().getResource("/layouts/ejemplo/imagenes/imagen2.png").toExternalForm()),
                new Contact("Chat 3", getClass().getResource("/layouts/ejemplo/imagenes/imagen3.png").toExternalForm())
        );
        chatList.setCellFactory(param -> new ContactCell());
        chatList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            // Aquí puedes cargar el chat seleccionado en el área de chat
            chatArea.setText("Chat seleccionado: " + newValue.getName());
        });

        // VBox para contener la lista de chats y su etiqueta
        VBox leftBox = new VBox();
        leftBox.getChildren().addAll(new Label("Chats"), chatList);

        // TextArea para mostrar el área de chat
        chatArea = new TextArea();
        chatArea.setEditable(false);

        // TextField para escribir mensajes
        mensajeField = new TextField();
        mensajeField.setPromptText("Escribe un mensaje...");
        mensajeField.setOnAction(e -> enviarMensaje());
        mensajeField.setPrefWidth(250); // Ajusta el ancho del recuadro de texto

        // Botón para enviar mensajes
        Button enviarButton = new Button("Enviar");
        enviarButton.setOnAction(e -> enviarMensaje());

        // HBox para contener el campo de texto y el botón de enviar
        HBox bottomBox = new HBox(10);
        bottomBox.getChildren().addAll(mensajeField, enviarButton);
        bottomBox.setAlignment(javafx.geometry.Pos.BOTTOM_RIGHT);

        // VBox para contener el área de chat y el campo de entrada de mensajes
        VBox centerBox = new VBox(10);
        VBox.setVgrow(chatArea, Priority.ALWAYS); // Hacer que el área de chat ocupe todo el espacio disponible
        centerBox.getChildren().addAll(chatArea, bottomBox);

        root.setLeft(leftBox);
        root.setCenter(centerBox);

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Interface Layouts");
        primaryStage.show();
    }

    private void enviarMensaje() {
        String mensaje = mensajeField.getText().trim();
        if (!mensaje.isEmpty()) {
            chatArea.appendText("Tú: " + mensaje + "\n");
            mensajeField.clear();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
