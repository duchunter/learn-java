// StudentPoll.java - section 7.4
// Poll analysis program

public class StudentPoll {
  public static void main(String[] args) {
    // Student responses array
    int[] responses = {
      1, 2, 5, 4, 3, 5, 2, 1, 3, 3, 1, 4, 3, 3, 3, 2, 3, 3, 2, 14
    };
    int responsesLength = responses.length;

    // Frequency counter
    int[] frequency = new int[6];
    int frequencyLength = frequency.length;

    // Increase correspond frequency value for each answer
    for (int i = 0; i < responsesLength; i++) {
      try {
        // Increase frequency counter
        frequency[responses[i] - 1] += 1;
      } catch (ArrayIndexOutOfBoundsException e) {
        // Catch index out of bound error
        System.out.println(e);
        System.out.printf(
          "responses[%d] = %d\n\n", i, responses[i]
        );
      }
    }

    // Ouput result
    System.out.printf("%s%12s\n", "Rating", "Frequency");
    for (int rating = 0; rating < frequencyLength; rating++) {
      System.out.printf("%6d%12d\n", rating + 1, frequency[rating]);
    }
  }
}
