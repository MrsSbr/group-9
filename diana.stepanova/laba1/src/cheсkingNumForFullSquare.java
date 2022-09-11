public class cheсkingNumForFullSquare {
    private int num;

    public void setValue(int num) {
        this.num = num;
    }

    public void createValue() {
        int number;
        number = cheсkingTheNumVariable.cheсkingTheVariable();
        setValue(number);
    }

    public boolean returnsFullSquare() {
        if (num == 1) return true;
        int ind = 1;
        while (ind * ind <= num) {
            if (ind * ind != num) {
                ind++;
                continue;

            }
            return true;
        }
        return false;


    }
}


