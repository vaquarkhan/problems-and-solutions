package hackerearth.java.com.vaquar.mobitrans.friendCircles;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedTransferQueue;

public class FriendCircles {

    static int friendCircles(String[] friends) {

	Queue<Integer> friendCircleQueue = new LinkedTransferQueue<Integer>();
	int count = 0;
	for (int i = 0; i < friends.length; i++) {
	    if (friends[i].contains("Y")) {
		count++;
		friends[i] = identifyFriends(friends[i], friendCircleQueue);
		while (!friendCircleQueue.isEmpty()) {
		    int curFriend = friendCircleQueue.poll();
		    // Identify friends of friends
		    friends[curFriend] = identifyFriends(friends[curFriend], friendCircleQueue);
		}
	    }
	}
	return count;
    }

    @SuppressWarnings("unchecked")
    static String identifyFriends(String friends, Queue<Integer> friendCircleQueue) {
	int friendIndex;
	while ((friendIndex = friends.indexOf('Y')) != -1) {
	    friendCircleQueue.add(friendIndex);
	    friends = friends.replaceFirst("Y", "N");
	}
	return friends;
    }

    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	int numFriends = Integer.parseInt(scanner.nextLine());
	String[] friends = new String[numFriends];
	for (int i = 0; i < numFriends; i++) {
	    friends[i] = scanner.nextLine();
	}
	System.out.println(friendCircles(friends));
    }
}