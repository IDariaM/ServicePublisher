package idariam.Publisher.service;

import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class PublisherService {

    private ArrayList<String> actions = new ArrayList<>(); //ArrayList with actions' names
    private Map<String, String> result; //map to be filled with data and returned as response


    public Map<String, String> createResponse() {
        result = new HashMap<>();
        result.put("msisdn", msisdnCreation());
        result.put("action", chooseAction());
        result.put("timestamp", String.valueOf(new Timestamp(System.currentTimeMillis()).getTime()));
        return result;

    }

    //method for msisdn generation
    public String msisdnCreation() {
        StringBuilder result = new StringBuilder();
        //arraylist with nums 0-9
        List<Integer> nums = IntStream.range(0, 9).boxed()
                .collect(Collectors.toCollection(ArrayList::new));
        Collections.shuffle(nums);
        for (int i : nums) {
            result.append(i);
        }
        return result.toString();
    }

    //choose random action

    public String chooseAction() {
        actions.add("PURCHASE");
        actions.add("SUBSCRIPTION");
        Collections.shuffle(actions);
        return actions.get(0);
    }
}
