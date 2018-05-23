public final class Singltone {
    private Singltone ex;
    private Singltone(){}
    public Singltone createObj(){
        if(ex == null){
            ex=new Singltone();
        }
        return ex;
    }
}
