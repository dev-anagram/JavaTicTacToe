public class Main {

    public static void main(String[] args) throws InterruptedException {
        boolean run = true, runGM = true, game = true;
        int option, optionGM;
        char player1 = 'X', player2 = 'O';


        while(run){
            Func.menu();
            option = Func.scanInt();
            switch(option) {
                case 1:
                    Func.gamemode();
                    optionGM = Func.scanInt();
                    while(runGM) {
                        switch (optionGM) {
                            case 1:

                                break;
                            case 2:
                                Game.duo(game, player1, player2);
                                runGM = false;
                                break;
                            case 3:
                                runGM = false;
                                break;
                            default:
                                Func.sysError();
                                break;
                        }
                    }
                    break;
                case 2:
                    Func.info();
                    break;
                case 3:
                    Func.sysFarewell();
                    Thread.sleep(2000);
                    run = false;
                    break;
                default:
                    Func.sysError();
            }
        }
    }
}