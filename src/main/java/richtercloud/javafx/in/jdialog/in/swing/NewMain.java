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
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class NewMain extends JFrame {
    private static final long serialVersionUID = 1L;
    private final JFXPanel mainPanel = new JFXPanel();
    private final ImageView imageView;
    private final JButton closeButton = new JButton("Close");

    public NewMain() throws HeadlessException {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(0, 0, 800, 600);
        setPreferredSize(new Dimension(800, 600));
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);
        this.imageView = new ImageView(NewMain.class.getResource("/File_CC-BY-SA_3_icon_88x31.png").toString());
        Platform.runLater(() -> {
            BorderPane borderPane = new BorderPane();
            Button bottomButton = new Button("Some button");
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
        closeButton.addActionListener((event) -> {
            setVisible(false);
        });
        layout.setHorizontalGroup(layout.createParallelGroup()
                .addComponent(mainPanel)
                .addComponent(closeButton));
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(mainPanel)
                .addComponent(closeButton));
        pack();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new NewMain().setVisible(true);
        });
    }
}
