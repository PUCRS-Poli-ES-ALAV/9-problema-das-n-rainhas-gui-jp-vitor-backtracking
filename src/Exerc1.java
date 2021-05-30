import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exerc1 {
    public static void main(String[] args) {
        List<List<Pair<Integer, Integer>>> solutions = nQueenSolve(7);
        if (solutions.isEmpty()) {
            System.out.println("There is no solution");
        } else {
            solutions.forEach(solution -> {
                System.out.println("====================");
                System.out.println(String.join("||", solution.toString()));
                System.out.println("====================");
            });
        }
    }

    private static List<List<Pair<Integer, Integer>>> nQueenSolve(int size) {
        Optional<Pair<Integer, Integer>> currentPosition = Optional.of(new Pair<>(0, 0));
        List<List<Pair<Integer, Integer>>> solutions = new ArrayList<>();
        List<Pair<Integer, Integer>> board = new ArrayList<>();
        while (currentPosition.isPresent()) {
            board.add(currentPosition.get());
            currentPosition = generateNextSinglePosition(currentPosition.get(), size);
        }
        board.forEach(position -> {
            List<Pair<Integer, Integer>> track = new ArrayList<>();
            nQueenSolveAux(size, position, track, solutions);
        });
        return solutions;
    }

    private static void nQueenSolveAux(int size, Pair<Integer, Integer> currentPosition,
                                       List<Pair<Integer, Integer>> track,
                                       List<List<Pair<Integer, Integer>>> solutions) {
        boolean currentIsValid = isValid(currentPosition, track, size);
        if (currentIsValid) {
            track.add(currentPosition);
            Optional<Pair<Integer, Integer>> nextP = generateNextSinglePosition(currentPosition, size);
            nextP.ifPresent(integerIntegerPair -> nQueenSolveAux(size, integerIntegerPair, track, solutions));
            return;
        }
        if (track.size() == size) {
            solutions.add(new ArrayList<>(track));
            List<Pair<Integer, Integer>> newTrack = new ArrayList<>(track);
            Optional<Pair<Integer, Integer>> nextP = generateNextSinglePosition(currentPosition, size);
            nextP.ifPresent(integerIntegerPair -> nQueenSolveAux(size, integerIntegerPair, newTrack, solutions));
            return;
        }
        if (!track.isEmpty()) {
            Optional<Pair<Integer, Integer>> nextP = generateNextSinglePosition(currentPosition, size);
            nextP.ifPresent(integerIntegerPair -> nQueenSolveAux(size, integerIntegerPair, track, solutions));
        }
    }

    private static boolean isValid(Pair<Integer, Integer> currentPosition, List<Pair<Integer, Integer>> track,
                                   int size) {
        int lineIndex = currentPosition.getKey();
        int columnIndex = currentPosition.getValue();
        for (Pair<Integer, Integer> pair : track) {
            if (pair.getKey() == lineIndex || pair.getValue() == columnIndex) {
                return false;
            }
        }
        for (int i = 1; i < size; i++) {
            Pair<Integer, Integer> NE, NW, SE, SW;
            NE = new Pair<>(currentPosition.getKey() - i, currentPosition.getValue() + i);
            NW = new Pair<>(currentPosition.getKey() - i, currentPosition.getValue() - i);
            SE = new Pair<>(currentPosition.getKey() + i, currentPosition.getValue() + i);
            SW = new Pair<>(currentPosition.getKey() + i, currentPosition.getValue() - i);
            if (NE.getKey() >= 0 && NE.getValue() < size) {
                if (track.contains(NE)) return false;
            }
            if (NW.getKey() >= 0 && NW.getValue() >= 0) {
                if (track.contains(NW)) return false;
            }
            if (SE.getKey() < size && SE.getValue() < size) {
                if (track.contains(SE)) return false;
            }
            if (SW.getKey() < size && SW.getValue() >= 0) {
                if (track.contains(SW)) return false;
            }
        }
        return true;
    }

    private static Optional<Pair<Integer, Integer>> generateNextSinglePosition(Pair<Integer, Integer> currentPosition, int n) {
        if (currentPosition.getValue() == n - 1) {
            if (currentPosition.getKey() == n - 1) {
                return Optional.empty();
            }
            return Optional.of(new Pair<>(currentPosition.getKey() + 1, 0));
        } else {
            return Optional.of(new Pair<>(currentPosition.getKey(), currentPosition.getValue() + 1));
        }
    }
}
