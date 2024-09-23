package tabs;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class AddView {

    private Label addPaneLabel;
    private TextField textField;
    private Button addRecipe;

    public StackPane getView(){

        StackPane addPane = new StackPane();
        addPane.setAlignment(Pos.CENTER);

        addPaneLabel = new Label("Enter your recipe name ");
        textField = new TextField();
        addRecipe = new Button("add");

        textField.setMaxWidth(150);

        HBox addPaneHBox = new HBox();
        addPaneHBox.setSpacing(5);
        addPaneHBox.setAlignment(Pos.CENTER);
        addPaneHBox.getChildren().addAll(addPaneLabel,textField, addRecipe);

        addPane.getChildren().add(addPaneHBox);

        return addPane;
    }

    public Label getAddPaneLabel() {
        return addPaneLabel;
    }

    public void setAddPaneLabel(String text) {
        this.addPaneLabel.setText(text);
    }

    public TextField getTextField() {
        return textField;
    }

    public void setTextField(TextField textField) {
        this.textField = textField;
    }

    public Button getAddRecipe() {
        return addRecipe;
    }

    public void setAddRecipe(Button addRecipe) {
        this.addRecipe = addRecipe;
    }
}
