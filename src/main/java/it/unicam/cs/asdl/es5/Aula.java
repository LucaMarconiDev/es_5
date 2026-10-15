package it.unicam.cs.asdl.es5;

import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

// TODO importare eventuali classi o interfacce che servono

/**
 * Rappresenta un’aula identificata univocamente dal nome, con dotazioni e prenotazioni.
 * <p>Le dotazioni sono conservate in un {@link java.util.Set}: non ammettono
 * duplicati secondo {@code equals}/{@code hashCode}. Le prenotazioni sono
 * conservate in un {@link java.util.SortedSet}, ordinato secondo
 * {@link Prenotazione#compareTo(Prenotazione)}.
 * <p>Questa classe riprende il modello dell’esercitazione 4, sostituendo gli
 * array con le Collections studiate nelle slide.
 * <p><strong>Nota sull’incapsulamento:</strong> i getter delle collezioni
 * restituiscono riferimenti agli insiemi interni (non copie difensive);
 * modificandoli si può aggirare la validazione dei metodi dell’aula.
 *
 * @author Template: Luca Tesei, Implementazione: Collettiva
 *
 */
public class Aula implements Comparable<Aula> {
    // Identificativo unico di un'aula
    private final String nome;

    // Location dell'aula
    private final String location;

    // Insieme delle facilities di quest'aula
    private final Set<Facility> facilities;

    // Insieme delle prenotazioni per quest'aula, segue l'ordinamento naturale
    // delle prenotazioni
    private final SortedSet<Prenotazione> prenotazioni;

    /**
     * Costruisce una certa aula con nome e location. Il set delle facilities è
     * vuoto. L'aula non ha inizialmente nessuna prenotazione.
     *
     * @param nome
     *                     il nome dell'aula
     * @param location
     *                     la location dell'aula
     *
     * @throws NullPointerException
     *                                  se una qualsiasi delle informazioni
     *                                  richieste è nulla
     */
    public Aula(String nome, String location) {
        // TODO implementare
        this.nome = nome;
        this.location = location;
        this.facilities = new HashSet<Facility>();
        this.prenotazioni = new TreeSet<Prenotazione>();
    }

    /**
     * Costruisce una certa aula con nome, location e insieme delle facilities.
     * L'aula non ha inizialmente nessuna prenotazione.
     *
     * @param nome
     *                       il nome dell'aula
     * @param location
     *                       la location dell'aula
     * @param facilities
     *                       l'insieme delle facilities dell'aula
     * @throws NullPointerException
     *                                  se una qualsiasi delle informazioni
     *                                  richieste è nulla
     */
    public Aula(String nome, String location, Set<Facility> facilities) {
        // TODO implementare
        this.nome = nome;
        this.location = location;
        this.facilities = facilities;
        this.prenotazioni = new TreeSet<Prenotazione>();
    }

    /**
     * Calcola l’hash dall’identificativo immutabile dell’aula.
     * <p>Il risultato deve essere coerente con {@link #equals(Object)}
     * affinché l’aula funzioni correttamente in {@link java.util.HashSet}.
     * @return codice hash del nome
     */
    @Override
    public int hashCode() {
        // TODO implementare
        return -1;
    }

    /**
     * Confronta l’identità logica delle aule: conta soltanto il nome,
     * non la posizione, le dotazioni o le prenotazioni.
     * @param obj oggetto da confrontare
     * @return {@code true} se {@code obj} è un’aula con lo stesso nome
     */
    @Override
    public boolean equals(Object obj) {
        // TODO implementare
        return false;
    }

    /**
     * Definisce l’ordinamento naturale lessicografico per nome,
     * compatibile con {@link #equals(Object)}.
     * @param o aula da confrontare
     * @return valore negativo, zero o positivo secondo l’ordine dei nomi
     * @throws NullPointerException se {@code o} è {@code null}
     */
    @Override
    public int compareTo(Aula o) {
        // TODO implementare
        return -1;
    }

    /**
     * Restituisce le dotazioni dell’aula.
     * @return l’insieme delle dotazioni dell’aula (riferimento interno modificabile)
     */
    public Set<Facility> getFacilities() {
        return facilities;
    }

    /**
     * Restituisce il nome identificativo dell’aula.
     * @return il nome identificativo dell’aula
     */
    public String getNome() {
        return nome;
    }

    /**
     * Restituisce la posizione dell’aula.
     * @return la posizione dell’aula
     */
    public String getLocation() {
        return location;
    }

    /**
     * Restituisce le prenotazioni ordinate dell’aula.
     * @return l’insieme ordinato delle prenotazioni (riferimento interno modificabile)
     */
    public SortedSet<Prenotazione> getPrenotazioni() {
        return prenotazioni;
    }

    /**
     * Aggiunge una dotazione all’insieme {@code Set<Facility>} dell’aula.
     * <p>Il risultato di {@code Set.add} indica se l’insieme è cambiato.
     *
     * @param f
     *              la facility da aggiungere
     * @return true se la facility non era già presente e quindi è stata
     *         aggiunta, false altrimenti
     * @throws NullPointerException
     *                                  se la facility passata è nulla
     */
    public boolean addFacility(Facility f) {
        // TODO implementare
        return false;
    }

    /**
     * Determina se l’aula è libera nell’intervallo richiesto.
     * <p>Le prenotazioni sono ordinate per intervallo: è possibile interrompere
     * la scansione quando l’inizio della prenotazione corrente è successivo
     * all’intervallo richiesto. L’eventuale sovrapposizione è determinata
     * da {@link TimeSlot#overlapsWith(TimeSlot)}.
     *
     * @param ts
     *               il time slot da controllare
     *
     * @return true se l'aula risulta libera per tutto il periodo del time slot
     *         specificato
     * @throws NullPointerException
     *                                  se il time slot passato è nullo
     */
    public boolean isFree(TimeSlot ts) {
        // TODO implementare
        /*
         * NOTA: sfruttare l'ordinamento tra le prenotazioni per rispondere in
         * maniera efficiente: poiché le prenotazioni sono in ordine crescente
         * di time slot se arrivo a una prenotazione che segue il time slot
         * specificato posso concludere che l'aula è libera nel time slot
         * desiderato e posso interrompere la ricerca
         */
        return false;
    }

    /**
     * Determina se ogni dotazione richiesta è soddisfatta da almeno una dotazione
     * presente nell’aula.
     * <p>Non basta {@code containsAll}: il metodo
     * {@link Facility#satisfies(Facility)} esprime una relazione di
     * soddisfacimento che può essere diversa da {@code equals}.
     *
     * @param requestedFacilities
     *                                l'insieme di facilities richieste da
     *                                soddisfare
     * @return true se e solo se tutte le facilities di
     *         {@code requestedFacilities} sono soddisfatte da questa aula.
     * @throws NullPointerException
     *                                  se il set di facility richieste è nullo
     */
    public boolean satisfiesFacilities(Set<Facility> requestedFacilities) {
        // TODO implementare
        return false;
    }

    /**
     * Inserisce una prenotazione nell’insieme ordinato solo se l’intervallo è libero.
     * <p>L’ordinamento naturale di {@link Prenotazione} è utilizzato da
     * {@link java.util.TreeSet} per mantenere le prenotazioni ordinate.
     *
     * @param ts intervallo richiesto
     * @param docente docente responsabile
     * @param motivo motivo della prenotazione
     * @throws IllegalArgumentException
     *                                      se la prenotazione comporta una
     *                                      sovrapposizione con un'altra
     *                                      prenotazione nella stessa aula.
     * @throws NullPointerException
     *                                      se una qualsiasi delle informazioni
     *                                      richieste è nulla.
     */
    public void addPrenotazione(TimeSlot ts, String docente, String motivo) {
        // TODO implementare
    }

    /**
     * Rimuove una prenotazione dal {@code SortedSet}.
     * <p>In {@code TreeSet} la ricerca avviene secondo l’ordinamento naturale,
     * che deve essere compatibile con l’uguaglianza logica.
     *
     * @param p
     *              la prenotazione da cancellare
     * @return true se la prenotazione è stata cancellata, false se non era
     *         presente.
     * @throws NullPointerException
     *                                  se la prenotazione passata è null
     */
    public boolean removePrenotazione(Prenotazione p) {
        // TODO implementare
        return false;
    }

    /**
     * Rimuove tutte le prenotazioni il cui istante iniziale è minore o uguale
     * a {@code timePoint}, senza considerare l’istante finale.
     * <p>L’ordinamento consente di interrompere la scansione alla prima
     * prenotazione successiva; per eliminare durante la scansione si usa
     * {@link java.util.Iterator#remove()}, non {@code Set.remove}.
     *
     * @param timePoint
     *                      un certo punto nel tempo
     * @return true se almeno una prenotazione è stata cancellata, false
     *         altrimenti.
     * @throws NullPointerException
     *                                  se il punto nel tempo passato è nullo.
     */
    public boolean removePrenotazioniBefore(GregorianCalendar timePoint) {
        // TODO implementare
        /*
         * NOTA: sfruttare l'ordinamento tra le prenotazioni per rispondere in
         * maniera efficiente: poiché le prenotazioni sono in ordine crescente
         * di time slot se ho raggiunto una prenotazione con tempo di inizio
         * maggiore del tempo indicato posso smettere la procedura
         */
        return false;
    }
}
