/**
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package richtercloud.javafx.in.jdialog.in.swing;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class NewMain1 extends Application {
    private final ImageView imageView;

    public NewMain1() {
        this.imageView = new ImageView(NewMain.class.getResource("/File_CC-BY-SA_3_icon_88x31.png").toString());
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane borderPane = new BorderPane();
        Button bottomButton = new Button("Some button");
        ScrollPane imageViewScrollPane = new ScrollPane(imageView);
        borderPane.setCenter(imageViewScrollPane);
        borderPane.setBottom(bottomButton);
        imageView.setSmooth(true);
        imageView.setFitHeight(400);
        StackPane  root  =  new  StackPane();
        root.getChildren().add(borderPane);
        stage.setScene(new Scene(root, 800, 600));
        stage.show();
    }
}