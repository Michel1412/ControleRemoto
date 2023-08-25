public class ControleRemoto implements Controlador{

    private int volume;
    private boolean ligado;
    private boolean tocando;

    //setters

    private void setVolume(int volume) {
        this.volume = volume;
    }

    private void setLigado(boolean ligado) {
        this.ligado = ligado;
    }

    private void setTocando(boolean tocando) {
        this.tocando = tocando;
    }

    //getters

    private int getVolume() {
        return volume;
    }

    private boolean getLigado() {
        return ligado;
    }

    private boolean getTocando() {
        return tocando;
    }

    //contruct

    public ControleRemoto() {
        this.setVolume(50);
        this.setLigado(false);
        this.setTocando(false);
    }


    @Override
    public void ligar() {
        System.out.println("Ligando...");
        this.setLigado(true);
    }

    @Override
    public void desligar() {
        System.out.println("Desligando...");
        this.setLigado(false);
    }

    @Override
    public void menosVolume() {
        if (this.getLigado() && this.getVolume() > 0){
            this.setVolume(this.getVolume() - 1);
        }
    }

    @Override
    public void maisVolume() {
        if (this.getLigado() && this.getVolume() < 100){
            this.setVolume(this.getVolume() + 1);
        }
    }

    @Override
    public void abrirMenu() {
        System.out.println("----------MENU----------");
        System.out.println("Está ligado: " + this.getLigado());
        System.out.println("Está tocando: " + this.getTocando());
        System.out.print("Volume: " + this.getVolume());
        for (int x = 0; x <= getVolume(); x+=10){
            System.out.print("[]");
        }
        System.out.println(" ");
    }

    @Override
    public void fecharMenu() {
        System.out.println("Fechando menu...");
    }

    @Override
    public void ligarMudo() {
        if (this.getLigado() && this.getVolume() > 0){
            this.setVolume(0);
        }
    }

    @Override
    public void desligarMudo() {
        if (this.getLigado() && this.getVolume() == 0){
            this.setVolume(50);
        }
    }

    @Override
    public void play() {
        if (this.getLigado() && !(this.getTocando())){
            this.setTocando(true);
        }
    }

    @Override
    public void pause() {
        if (this.getLigado() && this.getTocando()){
            this.setTocando(false);
        }
    }
}
