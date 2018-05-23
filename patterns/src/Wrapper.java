public class Wrapper {
    private String str;
    public Wrapper (String str){
        this.str = str;
    }
    public String add(String str){
        this.str = this.str+str;
        return this.str;
    }
    public String remove(String str){
        this.str = this.str.replaceAll(str,"");
        return this.str;
    }
}
