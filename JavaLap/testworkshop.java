package JavaLap;

import javax.swing.JOptionPane;

public class testworkshop {
    public static void main(String[] args) {
        String order = " ";
        String bill = "Your order:\n";
        String money = "Enter money: ";
        String detail = ": ";
        String menu = "Select Your order beverage order: \n[P] [Pepsi] 15\n[F] [Fanta] 15\n[C] Go [Coffee] 20\n[S] [Sprite] 20\n[M] [Mineral] Water 18\n[0] End order \n [EXIT]";
        int total = 0;
        do {
            order = JOptionPane.showInputDialog(null, menu, "Order", 1);
            String orderLower = order.toLowerCase();
            if (orderLower.equals("exit")) {
                return;
            }
            if (order.equals("0")) {
                break;
            }
            String[] words = order.split(" ");
            for (String word : words) {
                System.out.println(word);
            }
            String beverage = words[0].toLowerCase();
            if (beverage.equals("pepsi") || beverage.equals("p")) {
                int price = 15;
                int qty = Integer.parseInt(words[1]);
                int unit = price * qty;

                total += unit;
                bill += "PEPSI 15 x " + qty + " = " + (price*qty) + "\n";
                if (detail.equals(": ")) {
                    detail += unit;
                } else {
                    detail += " + " + unit;
                }
            } else if (beverage.equals("fanta") || beverage.equals("f")) {
                int price = 15;
                int qty = Integer.parseInt(words[1]);
                int unit = price * qty;

                total += unit;
                bill += "Fanta 15 x " + qty + " = " + (price*qty) + "\n";
                if (detail.equals(": ")) {
                    detail += unit;
                } else {
                    detail += " + " + unit;
                }

            } else if (beverage.equals("coffee") || beverage.equals("c")) {
                int price = 20;
                int qty = Integer.parseInt(words[1]);
                int unit = price * qty;

                total += unit;
                bill += "Coffee 20 x " + qty + " = " + (price*qty) + "\n";
                if (detail.equals(": ")) {
                    detail += unit;
                } else {
                    detail += " + " + unit;
                }

            } else if (beverage.equals("sprite") || beverage.equals("s")) {
                int price = 20;
                int qty = Integer.parseInt(words[1]);
                int unit = price * qty;

                total += unit;
                bill += "Sprite 20 x " + qty + " = " + (price*qty) + "\n";
                if (detail.equals(": ")) {
                    detail += unit;
                } else {
                    detail += " + " + unit;
                }

            }else if (beverage.equals("mineral") || beverage.equals("m")) {
                int price = 18;
                int qty = Integer.parseInt(words[1]);
                int unit = price * qty;

                total += unit;
                bill += "Mineral 18 x " + qty + " = " + (price*qty) + "\n";
                if (detail.equals(": ")) {
                    detail += unit;
                } else {
                    detail += " + " + unit;
                }

            }
        } while (true);
        bill += "Total: " + detail + " = " + total;
        JOptionPane.showMessageDialog(null, bill,"order",1);
        money = JOptionPane.showInputDialog(null, money, "money", 1);
        int moneyInt = Integer.parseInt(money);
        int resultTotal = moneyInt - total;
        int change = moneyInt - total;

        int A = change / 1000;
        change = change % 1000;
        int B = change / 500;
        change = change % 500;
        int C = change / 100;
        change = change % 100;
        int D = change / 50;
        change = change % 50;
        int e = change / 20;
        change = change % 20;
        int f = change / 10;
        change = change % 10;
        int g = change / 5;
        change = change % 5;
        int h = change / 2;
        change = change % 2;
        int i = change / 1;
        change = change % 1;
        String changeStr = "Remain "+ money + " - " + total +" = " + resultTotal + "\n===============\n Result of Money exchange : \n1000 ="+ A + "\n500 ="+ B + "\n100 ="+ C + "\n50 ="+ D + "\n20 ="+ e + "\n10 ="+ f + "\n5 ="+ g + "\n2 ="+ h + "\n1 ="+ i +"\nThank you for your order \nSee you soon";
        JOptionPane.showMessageDialog(null, changeStr,"Change",1);
    }
}
