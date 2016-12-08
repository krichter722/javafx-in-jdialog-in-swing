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

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 *
 * @author richter
 */
public class NewMain2 extends JFrame {
    private static final long serialVersionUID = 1L;
    private final JFXPanel mainPanel = new JFXPanel();
    private final ImageView imageView;

    public NewMain2() throws HeadlessException {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(0, 0, 800, 600);
        setPreferredSize(new Dimension(800, 600));
        BorderLayout layout = new BorderLayout();
        this.getContentPane().setLayout(layout);
        this.imageView = new ImageView(NewMain.class.getResource("/File_CC-BY-SA_3_icon_88x31.png").toString());
        Platform.runLater(() -> {
            BorderPane borderPane = new BorderPane();
            Button bottomButton = new Button("Some button");
            bottomButton.setOnAction((event) ->  {
                SwingUtilities.invokeLater(() -> {
                    NewMain2.this.setVisible(false);
                });
            });
            ScrollPane imageViewScrollPane = new ScrollPane(imageView);
            borderPane.setCenter(imageViewScrollPane);
            borderPane.setBottom(bottomButton);
            imageView.setSmooth(true);
            imageView.setFitHeight(400);
            Group  root  =  new  Group();
            Scene  scene  =  new  Scene(root, Color.ALICEBLUE);
            root.getChildren().add(borderPane);
            mainPanel.setScene(scene);
        });
        this.getContentPane().add(mainPanel);
        pack();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new NewMain2().setVisible(true);
        });
    }
}
