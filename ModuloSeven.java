public class ModuloSeven {
    public static void main(String[] args) {
        for (int i = 1; i <= 999; i++) {
            System.out.print(i+"."+i % 7 + " ");
            if (i % 25 == 0) { // ขึ้นบรรทัดใหม่ทุก 50 ตัว เพื่อให้อ่านง่าย
                System.out.println();
            }
        }
    }
}
