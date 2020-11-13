package Denis_Belski.cross_zeross;

public class main {
    public static void main(String[] args) {

        customer customer = new customer();

        if(customer.checkGameRules()) {
            //создаем поле
            game_field game_field = new game_field();
            //проверим, за кого играет пользователь
            int returnCode = customer.get_X_or_O();
            //пользователь хочет прервать игру?
            if(returnCode > 1) {
                return;
            } else {
                game_field.getCustomerMark(returnCode); //указываем, за кого играет пользователь
            }
            //покажем игровое поле
            game_field.show_field();

            //начнем игру пока не будет введено 3 варианта или EXIT
            while(customer.checkCountAnswers() < 7) {
                game_field.getHardMode(customer.getMode());     //будем юзать хардМод
                // для простоты создадим переменную
                String whereMark = customer.getAnswer();

                if(whereMark.contentEquals("EXIT")) {
                    break;
                }

                //отправим ее на отображение на поле
                //putCustomerMark вызывает метод addCustomerMarkToField, а после - show_field
                int result = game_field.putCustomerMark(whereMark);

                if(game_field.getFreeField() == 1) {
                    System.out.println("The winner was not found. Glory to the robots!");
                    break;
                }

                if(result == 0) {
                    continue;
                } else if(result == 100) {
                    break;
                } else if(result == -100) {
                    break;
                }
            }

            //customer.getAnswer();



        }
    }
}
