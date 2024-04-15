package com.example.sortinganimation;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.text.Font;

import java.util.Random;

public class Principal extends Application {
    AnchorPane pane;
    Button botao_inicio;
    private Button vet[];
    private Button gerarValores;
    private Button ordena;
    Pane codePane;

    private Label labels[];

    public static void main(String[] args) {
        launch(args);

    }

    public void gerarValores() {
        Random random = new Random();
        for (int i = 0; i < vet.length; i++) {
            vet[i].setText(Integer.toString(random.nextInt(1001)));
        }
    }


    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Pesquisa e Ordenacao");
        pane = new AnchorPane();

        String[] gnomeSortCode = {
                "void gnomeSort() {",
                "    int index = 1;",
                "    int length = vet.length;",
                "",
                "    while (index < length) {",
                "        if (vet[index] < vet[index - 1]) {",
                "            int temp = vet[index];",
                "            vet[index] = vet[index - 1];",
                "            vet[index - 1] = temp;",
                "              if (index > 1)",
                "                index--;",
                "        } else",
                "            index++;",
                "    }",
                "}"
        };

        int numBotoes = 14;
        vet = new Button[numBotoes];
        gerarValores = new Button();
        ordena = new Button();
        gerarValores.setLayoutX(100);
        gerarValores.setLayoutY(50);

        gerarValores.setText("Gerar Valores");


        ordena.setLayoutY(50);
        ordena.setLayoutX(200);
        ordena.setText("Iniciar Ordenação");
        gerarValores.setOnAction(e -> gerarValores());
        ordena.setOnAction(e -> shellSort());
        pane.getChildren().add(gerarValores);
        pane.getChildren().add(ordena);


        labels = new Label[numBotoes];
        for (int i = 0; i < numBotoes; i++) {
            vet[i] = new Button();
            vet[i].setLayoutX(100 + i * 40);
            vet[i].setLayoutY(200);
            vet[i].setMinHeight(40);
            vet[i].setMinWidth(40);
            vet[i].setFont(new Font(14));
            vet[i].setStyle("-fx-background-color: #696969");
            vet[i].setStyle("--title-color: #696969");

            //vet[i].setVisible(false);

            labels[i] = new Label(Integer.toString(i));
            labels[i].setLayoutX(118 + i * 40);
            labels[i].setLayoutY(250);
            labels[i].setVisible(true);
            pane.getChildren().add(labels[i]);
            pane.getChildren().add(vet[i]);
        }

        codePane = new Pane();

        double y = 20;
        for (int i = 0; i < gnomeSortCode.length; i++) {
            Label lineLabel = new Label(gnomeSortCode[i]);
            lineLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 20));
            lineLabel.setLayoutX(20);
            lineLabel.setLayoutY(y);
            lineLabel.setTextFill(Color.BLACK);


            lineLabel.setStyle("-fx-background-color: white;");
            codePane.getChildren().add(lineLabel);
            y += 20;
        }

        // Destaque da linha específica
        codePane.setLayoutX(900);
        codePane.setLayoutY(50);

        pane.getChildren().add(codePane);
        Scene scene = new Scene(pane, 800, 600);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }

    private void highlightLine(int lineNumber) {
        if (lineNumber < 0 || lineNumber >= codePane.getChildren().size()) {
            return;
        }

        Label label = (Label) codePane.getChildren().get(lineNumber);
        label.setTextFill(Color.RED);

        PauseTransition pause = new PauseTransition(javafx.util.Duration.millis(500));
        pause.setOnFinished(event -> {
            label.setTextFill(Color.BLACK);
        });
        pause.play();
    }

    public void gnome_sort() {
        Task<Void> task = new Task<Void>() {
            int index = 1;
            boolean permutou = false;

            @Override
            protected Void call() {
                Platform.runLater(() -> {
                    highlightLine(1);
                });

                vet[index].setStyle("-fx-background-color: #c2c2c2");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                int length = vet.length;
                Platform.runLater(() -> {
                    highlightLine(2);
                });
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                while (index < length) {
                    Platform.runLater(() -> {
                        highlightLine(4);
                    });
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (Integer.parseInt(vet[index].getText()) < Integer.parseInt(vet[index - 1].getText())) {
                        Platform.runLater(() -> {
                            highlightLine(5);
                        });
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        Platform.runLater(() -> {
                            highlightLine(6);
                        });
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        Platform.runLater(() -> {
                            highlightLine(7);
                        });
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        Platform.runLater(() -> {
                            highlightLine(8);
                        });
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        for (int i = 0; i < 10; i++) {
                            Platform.runLater(() -> vet[index].setLayoutY(vet[index].getLayoutY() + 5));
                            Platform.runLater(() -> vet[index - 1].setLayoutY(vet[index - 1].getLayoutY() - 5));
                            try {
                                Thread.sleep(40);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                        Button buttonI = vet[index];
                        Button buttonJ = vet[index - 1];
                        final double posI = buttonI.getLayoutX();
                        final double posJ = buttonJ.getLayoutX();
                        final double diff = posJ - posI;

                        for (double y = 0; Math.abs(y) <= Math.abs(diff); y += (diff > 0 ? 5 : -5)) {
                            final double posY = y;
                            Button finalButtonI = buttonI;
                            Button finalButtonJ = buttonJ;
                            Platform.runLater(() -> {
                                finalButtonI.setLayoutX(posI + posY);
                                finalButtonJ.setLayoutX(posJ - posY);
                            });
                            try {
                                Thread.sleep(40);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        for (int i = 0; i < 10; i++) {
                            Platform.runLater(() -> vet[index].setLayoutY(vet[index].getLayoutY() - 5));
                            Platform.runLater(() -> vet[index - 1].setLayoutY(vet[index - 1].getLayoutY() + 5));
                            try {
                                Thread.sleep(40);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }


                        Button temp = vet[index];
                        vet[index] = vet[index - 1];
                        vet[index - 1] = temp;

                        if (index > 1) {
                            Platform.runLater(() -> {
                                highlightLine(9);
                            });
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            if (permutou) {

                                vet[index - 1].setStyle("-fx-background-color: #696969");
                                vet[index - 1].setStyle("--title-color: #696969");
                            } else {
                                vet[index].setStyle("-fx-background-color: #696969");
                                vet[index].setStyle("--title-color: #696969");
                            }

                            index--;
                            vet[index].setStyle("-fx-background-color: #c2c2c2");
                            Platform.runLater(() -> {
                                highlightLine(10);
                            });
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                    } else {
                        Platform.runLater(() -> {
                            highlightLine(11);
                        });
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        vet[index].setStyle("-fx-background-color: #696969");
                        vet[index].setStyle("--title-color: #696969");
                        index++;
                        System.out.println("passou aq");
                        vet[index].setStyle("-fx-background-color: #c2c2c2");

                        Platform.runLater(() -> {
                            highlightLine(12);
                        });
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

                for (int i = 0; i < vet.length; i++)
                    System.out.println(vet[i].getText());

                return null;
            }
        };
        Thread thread = new Thread(task);
        thread.start();
    }

    public void shellSort() {
        Task<Void> task = new Task<Void>() {
            int i, j, dist = 1, pos = 0, cont = 0;
            double aux = 0;

            @Override
            protected Void call() {
                while (dist < vet.length / 3) {
                    dist = dist * 3 + 1;
                }
                System.out.println(dist);

                while (dist > 0) {
                    for (i = dist; i < vet.length; i++) {
                        Button temp = vet[i];
                        int auxTemp = i;
                        for (int mudanca = 0; mudanca < 10; mudanca++) {
                            Platform.runLater(() -> vet[i].setLayoutY(vet[i].getLayoutY() - 5));
                            try {
                                Thread.sleep(50);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        j = i;

                        while (j >= dist && Integer.parseInt(vet[j - dist].getText()) > Integer.parseInt(temp.getText())) {
                            for (int i = 0; i < 10; i++) {
                                Platform.runLater(() -> vet[j - dist].setLayoutY(vet[j - dist].getLayoutY() + 5));
                                //Platform.runLater(() -> vet[j].setLayoutY(vet[j].getLayoutY() - 5));
                                try {
                                    Thread.sleep(50);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            System.out.println("-------------------");
                            System.out.println(j);
                            System.out.println(j - dist);
                            Button buttonI = vet[j];
                            Button buttonJ;
                               /* if (pos != 0)
                                    buttonJ = vet[j - dist];
                                else*/
                            buttonJ = vet[j - dist];
                            if (cont > 0)
                                aux = buttonJ.getLayoutX();
                            System.out.println("salvei em aux: " + aux);
                            final double posI = buttonI.getLayoutX();
                            final double posJ;

                            if (pos != 0) {
                                posJ = aux;
                                System.out.println("antigo pos j-dist " + aux);
                            }
                            else {
                                posJ = buttonJ.getLayoutX();
                            }
                            aux = posJ;
                            System.out.println("Pos j: " + posI);
                            System.out.println("Pos j - dist: " + posJ);
                            final double diff = posJ - posI;

                            for (double y = 0; Math.abs(y) <= Math.abs(diff); y += (diff > 0 ? 5 : -5)) {
                                final double posY = y;
                                Button finalButtonI = buttonI;
                                Button finalButtonJ = buttonJ;
                                Platform.runLater(() -> {
                                    //finalButtonI.setLayoutX(posI + posY);
                                    finalButtonJ.setLayoutX(posJ - posY);
                                });
                                try {
                                    Thread.sleep(80);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            pos += dist;

                            for (int i = 0; i < 10; i++) {
                                //Platform.runLater(() -> vet[j - dist].setLayoutY(vet[j - dist].getLayoutY() - 5));
                                Platform.runLater(() -> vet[j - dist].setLayoutY(vet[j - dist].getLayoutY() - 5));
                                try {
                                    Thread.sleep(50);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            
                            vet[j] = vet[j - dist];
                            j = j - dist;
                            cont++;
                        }

                        //if()
                        for (int mudanca = 0; mudanca < pos * 10; mudanca++) {
                            Platform.runLater(() -> temp.setLayoutX(temp.getLayoutX() - 4));
                            //Platform.runLater(() -> vet[1].setLayoutY(vet[1].getLayoutY() + 5));
                            try {
                                Thread.sleep(20);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                        for (int i = 0; i < 10; i++) {
                            Platform.runLater(() -> temp.setLayoutY(temp.getLayoutY() + 5));

                            // Platform.runLater(() -> vet[j].setLayoutX(vet[j].getLayoutX() - 5));
                            try {
                                Thread.sleep(50);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                        pos = 0;
                        //cont = 0;
                        vet[j] = temp;
                    }


                    dist = dist / 3;
                }
                for (int i = 0; i < vet.length; i++)
                    System.out.println(vet[i].getText() + "-");
                System.out.println();
                return null;
            }
        };
        Thread thread = new Thread(task);
        thread.start();
    }
}