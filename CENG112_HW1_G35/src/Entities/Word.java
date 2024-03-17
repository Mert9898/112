package Entities;

public class Word {
    private String content;
    private int length;
    
    public Word(String content) {
        this.content = content;
        this.length = content.length();
    }

    public String getContent() {
        return content;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        return content;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Word)) {
            return false;
        }
        Word otherWord = (Word) obj;
        return this.content.equals(otherWord.content);
    }
}
    
}
