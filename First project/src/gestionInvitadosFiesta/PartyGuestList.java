package gestionInvitadosFiesta;
import java.util.HashSet;
import java.util.Set;

public class PartyGuestList {
    private Set<String> guestList;

    public PartyGuestList() {
        guestList = new HashSet<>();
    }

    public void addGuest(String guest) {
        guestList.add(guest);
    }

    public void removeGuest(String guest) {
        guestList.remove(guest);
    }

    public boolean isGuestInList(String guest) {
        return guestList.contains(guest);
    }

    public int getTotalGuests() {
        return guestList.size();
    }

    public static void main(String[] args) {
        PartyGuestList partyGuestList = new PartyGuestList();

        // Agregar invitados
        partyGuestList.addGuest("Juan");
        partyGuestList.addGuest("Maria");
        partyGuestList.addGuest("Pedro");

        // Verificar si un invitado está en la lista
        System.out.println("¿Está Juan en la lista? " + partyGuestList.isGuestInList("Juan"));

        // Eliminar un invitado
        partyGuestList.removeGuest("Maria");

        // Mostrar el número total de invitados
        System.out.println("Número total de invitados: " + partyGuestList.getTotalGuests());

        // Verificar si la lista de invitados está vacía
        System.out.println("¿La lista de invitados está vacía? " + partyGuestList.guestList.isEmpty());
    }
}
