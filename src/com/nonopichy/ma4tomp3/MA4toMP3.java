package com.nonopichy.ma4tomp3;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MA4toMP3 extends Application {
    private File inputDirectory;
    private File outputDirectory;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("MA4 to MP3");

        StackPane root = new StackPane();

        Image logoImage = new Image("file:logo.png");
        ImageView imageView = new ImageView(logoImage);
        imageView.setFitWidth(150);
        imageView.setPreserveRatio(true);

        VBox imageBox = new VBox();
        imageBox.setAlignment(Pos.TOP_CENTER);
        imageBox.getChildren().addAll(imageView);
        root.getChildren().add(imageBox);

        Button inputButton = new Button("Input Folder");
        inputButton.setOnAction(e -> selectInputFolder(primaryStage));
        VBox.setMargin(inputButton, new javafx.geometry.Insets(10, 0, 0, 0)); // Adiciona margem acima do botão
        imageBox.getChildren().add(inputButton);

        Button outputButton = new Button("Output Folder");
        outputButton.setOnAction(e -> selectOutputFolder(primaryStage));
        VBox.setMargin(outputButton, new javafx.geometry.Insets(10, 0, 0, 0)); // Adiciona margem acima do botão
        imageBox.getChildren().add(outputButton);

        Button convertButton = new Button("Start Conversion");
        convertButton.setOnAction(e -> convertFiles());
        VBox.setMargin(convertButton, new javafx.geometry.Insets(10, 0, 0, 0)); // Adiciona margem acima do botão
        imageBox.getChildren().add(convertButton);

        Scene scene = new Scene(root, 250, 300);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private void selectInputFolder(Stage primaryStage) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Input Folder");
        inputDirectory = directoryChooser.showDialog(primaryStage);
    }

    private void selectOutputFolder(Stage primaryStage) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Output Folder");
        outputDirectory = directoryChooser.showDialog(primaryStage);
    }

    private void convertFiles() {
        if (inputDirectory == null || outputDirectory == null) {
            System.out.println("Please select input and output folders.");
            return;
        }

        File[] files = inputDirectory.listFiles((d, name) -> name.toLowerCase().endsWith(".m4a"));
        if (files == null || files.length == 0) {
            System.out.println("No .m4a files found in the input directory.");
            return;
        }

        List<String> commands = new ArrayList<>();
        for (File file : files) {
            String inputFilePath = file.getAbsolutePath();
            String outputFilePath = new File(outputDirectory, file.getName().replaceAll(".m4a$", ".mp3")).getAbsolutePath();
            commands.add("ffmpeg -i \"" + inputFilePath + "\" \"" + outputFilePath + "\"");
        }

        new Thread(() -> {
            for (String command : commands) {
                try {
                    Process process = Runtime.getRuntime().exec(command);
                    int exitCode = process.waitFor();
                    if (exitCode == 0) {
                        System.out.println("Successfully converted: " + command);
                    } else {
                        System.out.println("Error converting: " + command);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
