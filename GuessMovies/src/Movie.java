public class Movie implements Word {
    private String name;
    private String nameHidden;
    private int length;

    protected Movie(String name) {
        this.name = name;
        this.length = name.length();
        this.nameHidden = "";
        hideName();
    }

    private void hideName() {
        for (int i = 0; i < this.length; i++) {
            if (name.toCharArray()[i] == ' ') {
                this.nameHidden += " ";
            }

            this.nameHidden += "_";
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getLength() {
        return this.length;
    }

    protected String getHiddenName() {
        return this.nameHidden;
    }

    protected void updateHiddenName(String letter) {
        String tempWord = "";

        for (int i = 0; i < name.length(); i++) {
            if (name.toCharArray()[i] == letter.charAt(0)) {
                tempWord += letter;
            } else if (nameHidden.toCharArray()[i] != '_' && nameHidden.toCharArray()[i] != ' ') {
                tempWord += nameHidden.toCharArray()[i];
            } else if (nameHidden.toCharArray()[i] == ' ') {
                tempWord += ' ';
            } else {
                tempWord += "_";
            }
        }

        this.nameHidden = tempWord;
    }
}
