package com.company;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Grid extends Application {
    String player1;
    String player2;
    String gameVersion;
    public static void main(String[] args) {
        int x92=92;
        int x10=10;
        System.out.println(x92/x10);
        launch(args);

    }

    @Override
    public void start(Stage stage) {
        final int[] count = {0};
        final int[] countplayer1 = {0};
        final int[] countplayer2 = {0};
        while(true){
            gameVersion=PopUp.readLine("Geben Sie ihre Version ein(Classic oder Realistic)");
            if(gameVersion.equals("Classic")||gameVersion.equals("Realistic")){
                break;
            }else{
                System.out.println("Ungültig");
            }
        }
        player1=PopUp.readLine("Player1: Gib Name ein");
        player2=PopUp.readLine("Player2: Gib Name ein");
        stage.setTitle("Fünf gewinnt");

        if(gameVersion.equals("Classic")) {
            GridPane gridPane = new GridPane();
            Scene scene = new Scene(gridPane, 300, 300); // w, h
            stage.setScene(scene);
            gridPane.setPadding(new Insets(1));
            gridPane.setHgap(1);
            gridPane.setVgap(1);

            gridPane.setStyle("-fx-background-color: rgba(107,100,98,0.55);");

            Button[] end = new Button[100];
            for (int i = 0; i < end.length; i++) {
                end[i] = new Button("" + i);
                Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
                end[i].setPrefSize(screenBounds.getWidth(), screenBounds.getHeight());

                end[i].setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        if (count[0] % 2 == 0) {
                            if (((Button) (e.getSource())).getText() == "O") {
                            } else {
                                ((Button) (e.getSource())).setText("X");
                                count[0]++;
                                controlWinner(end, "X", stage);
                                ((Button) (e.getSource())).setStyle("-fx-background-color: #ff0000; ");
                            }
                            countplayer1[0]++;
                        } else {
                            if (((Button) (e.getSource())).getText() == "X") {
                            } else {
                                ((Button) (e.getSource())).setText("O");
                                count[0]++;
                                controlWinner(end, "O", stage);

                                ((Button) (e.getSource())).setStyle("-fx-background-color: #003CFFFF; ");
                            }
                            countplayer2[0]++;
                        }

                    }
                });

            }
            int z = 0;
            for (int index = 0; index < 10; index++) {
                for (int i = 0; i < 10; i++) {
                    gridPane.add(end[z], i, index);
                    z++;
                }

            }
            //gridPane.setGridLinesVisible(true);
            stage.show();
        }
    }
    public void controlWinner(Button[] x, String currentSymbol, Stage stage){
        String[][] control=new String[10][10];
        int c1=0;
        int horCount=0;
        int verCount=0;
        int dia1Count=0;
        int dia2Count=0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                control[j][i]=x[c1].getText();
                c1++;
            }
        }
        /*for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(control[j][i]);
            }
            System.out.println();
        }
         */
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(control[j][i]==currentSymbol){
                    horCount++;
                }else{
                    horCount=0;
                }
                if(control[i][j]==currentSymbol){
                    verCount++;
                }else{
                    verCount=0;
                }
                if(horCount>=5){
                    if(currentSymbol=="X") {
                        System.out.println(player1+" hat Gewonnen");
                    }
                    if(currentSymbol=="O") {
                        System.out.println(player2+" hat Gewonnen");
                    }
                    //schließe fenster
                    stage.close();
                }
                if(verCount>=5){
                    if(currentSymbol=="X") {
                        System.out.println(player1+" hat Gewonnen");
                    }
                    if(currentSymbol=="O") {
                        System.out.println(player2+" hat Gewonnen");
                    }
                    //schließe fenster
                    stage.close();
                }
            }
        }
        //diagonal
    }
}
