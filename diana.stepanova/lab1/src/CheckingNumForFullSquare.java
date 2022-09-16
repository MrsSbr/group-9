public class CheckingNumForFullSquare {
    private int num;

    public void setValue(int num) {
        this.num = num;
    }

    public void createValue() {
        setValue(CheckingTheNumVariable.checkingTheVariable());
    }

    public boolean returnsFullSquare() {
        if (num == 1) return true;
        int ind = 1;
        while (ind * ind <= num) {
            if (ind * ind == num) {
                return true;
            }
            ind++;
        }
        return false;


    }
}
