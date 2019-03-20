package com.bg;

import java.util.*;

import static com.bg.Action.*;

// Class definition for storing position of slots used within the car park.
// All the slots are stored within a LinkedHashMap and this is configurable
// based on the capacity specified through the constructor.

public class OneLevelCarPark {
    private Map<Integer, String> slots;
    private int capacity;
    private static final String EMPTY = "Empty";

    public OneLevelCarPark(int capacity) {
        slots = new LinkedHashMap<>();
        for (int i = 1; i <= capacity; i++) {
            slots.put(i, null);
        }
    }

    public String actionPerformed(List<Action> actions) throws UnsupportedActionException {
        String last_action_plate_number = null;
        for (Action action : actions) {
            if (action.getType().equals(PARK)) {
                // loop over the set using an entry set
                for (Map.Entry<Integer, String> entry : slots.entrySet()) {

                    Integer key = entry.getKey();
                    String value = entry.getValue();

                    if (value == null) {
                        slots.put(key, action.getPlateNumber());
                        last_action_plate_number = action.getPlateNumber();
                        break;
                    }
                }
            }
            else if (action.getType().equals(SMALLEST)) {
                List<Integer> values = new ArrayList<>();

                for (Map.Entry<Integer, String> entry : slots.entrySet()) {
                    last_action_plate_number = entry.getValue();

                    if (last_action_plate_number != null) {
                        values.add(Integer.parseInt(last_action_plate_number));
                    }
                }

                Integer min = Collections.min(values);
                last_action_plate_number = String.valueOf(min);

            }
            else if (action.getType().equals(DEPART)) {
                List<Integer> keys = new ArrayList<>();

                for (Map.Entry<Integer, String> entry : slots.entrySet()) {

                    Integer key = entry.getKey();
                    last_action_plate_number = entry.getValue();

                    if (last_action_plate_number != null) {
                        keys.add(key);
                    }
                }
                Integer max = Collections.max(keys);
                //Set parking slot back to empty.

                slots.put(max, null);
                last_action_plate_number = String.valueOf(slots.get(max-1));
            }
            else {
                throw new UnsupportedActionException("Unsupported Action, please enter valid action");
            }
        }
        return last_action_plate_number;
    }

}
