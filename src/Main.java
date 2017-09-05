import javax.sound.midi.*;
import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

public class Main extends JFrame {

    private MidiChannel[] mc;

    public Main(Synthesizer syn){
        mc = syn.getChannels();
        Instrument[] instr = syn.getDefaultSoundbank().getInstruments();
        syn.loadInstrument(instr[14]);
        mc[0].programChange(78);
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                mc[0].noteOn(toPitch(e),600);
            }

            public void keyReleased(KeyEvent e) {
                mc[0].noteOff(toPitch(e));
            }
        });
    }

    public static void main(String[] argss) throws MidiUnavailableException{
        Synthesizer syn = MidiSystem.getSynthesizer();
        syn.open();
        JFrame frame = new Main(syn);
        JLabel name = new JLabel("Keysboard");
        name.setFont(name.getFont().deriveFont(64.0f));
        frame.getContentPane().add(name);
        frame.setTitle("KEYSBOARD");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(375,170);
        frame.setVisible(true);
    }

    public int toPitch(KeyEvent k){
        switch(k.getKeyCode()){
            case KeyEvent.VK_A:
                return 60;
            case KeyEvent.VK_W:
                return 61;
            case KeyEvent.VK_S:
                return 62;
            case KeyEvent.VK_E:
                return 63;
            case KeyEvent.VK_D:
                return 64;
            case KeyEvent.VK_F:
                return 65;
            case KeyEvent.VK_T:
                return 66;
            case KeyEvent.VK_G:
                return 67;
            case KeyEvent.VK_Y:
                return 68;
            case KeyEvent.VK_H:
                return 69;
            case KeyEvent.VK_U:
                return 70;
            case KeyEvent.VK_J:
                return 71;
            case KeyEvent.VK_K:
                return 72;
            case KeyEvent.VK_O:
                return 73;
            case KeyEvent.VK_L:
                return 74;
            case KeyEvent.VK_P:
                return 75;
            case KeyEvent.VK_SEMICOLON:
                return 76;
            case KeyEvent.VK_QUOTE:
                return 77;
            case KeyEvent.VK_CLOSE_BRACKET:
                return 78;
            case KeyEvent.VK_ENTER:
                return 79;
            default:
                break;
        }
        return k.getKeyCode()%128;
    }
}
