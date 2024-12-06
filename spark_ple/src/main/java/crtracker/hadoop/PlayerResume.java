package crtracker.hadoop;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class PlayerResume implements Writable, Cloneable {
    private String utag;
    private String ctag;
    private int trophies;
    private int exp;
    private int league;
    private int bestleague;
    private String deck;
    private String evo;
    private String tower;
    private double strength;
    private int crown;
    private double elixir;
    private int touch;
    private int score;

    public PlayerResume() {
    }

    public PlayerResume(String utag, String ctag, int trophies, int exp, int league, int bestleague, String deck,
            String evo, String tower, double strength, int crown, double elixir, int touch, int score) {
        this.utag = utag;
        this.ctag = ctag;
        this.trophies = trophies;
        this.exp = exp;
        this.league = league;
        this.bestleague = bestleague;
        this.deck = deck;
        this.evo = evo;
        this.tower = tower;
        this.strength = strength;
        this.crown = crown;
        this.elixir = elixir;
        this.touch = touch;
        this.score = score;
    }

    public void write(DataOutput out) throws IOException {
        out.writeUTF(utag);
        out.writeUTF(ctag);
        out.writeInt(trophies);
        out.writeInt(exp);
        out.writeInt(league);
        out.writeInt(bestleague);
        out.writeUTF(deck);
        out.writeUTF(evo);
        out.writeUTF(tower);
        out.writeDouble(strength);
        out.writeInt(crown);
        out.writeDouble(elixir);
        out.writeInt(touch);
        out.writeInt(score);
    }

    public void readFields(DataInput in) throws IOException {
        utag = in.readUTF();
        ctag = in.readUTF();
        trophies = in.readInt();
        exp = in.readInt();
        league = in.readInt();
        bestleague = in.readInt();
        deck = in.readUTF();
        evo = in.readUTF();
        tower = in.readUTF();
        strength = in.readDouble();
        crown = in.readInt();
        elixir = in.readDouble();
        touch = in.readInt();
        score = in.readInt();
    }

    @Override
    public String toString() {
        return "PlayerResume [utag=" + utag + ", ctag=" + ctag + ", trophies=" + trophies + ", exp=" + exp
                + ", league=" + league + ", bestleague=" + bestleague + ", deck=" + deck + ", evo=" + evo
                + ", tower=" + tower + ", strength=" + strength + ", crown=" + crown + ", elixir=" + elixir
                + ", touch=" + touch + ", score=" + score + "]";
    }

    public boolean compareTo(PlayerResume player1) {
        if (this.utag.equals(player1.utag) && this.deck.equals(player1.deck) && this.evo.equals(player1.evo) && this.tower.equals(player1.tower)) {
            return true;
        }
        return false;
    }
}