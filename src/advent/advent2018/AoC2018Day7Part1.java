package advent.advent2018;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AoC2018Day7Part1 {
    public static void main(String[] args) {
        String result;

        result = test("Step C must be finished before step A can begin.\n" +
                "Step C must be finished before step F can begin.\n" +
                "Step A must be finished before step B can begin.\n" +
                "Step A must be finished before step D can begin.\n" +
                "Step B must be finished before step E can begin.\n" +
                "Step D must be finished before step E can begin.\n" +
                "Step F must be finished before step E can begin.");
        assert result.equals("CABDFE") : "unexpected result is " + result;
        System.out.println(result);

        result = test("Step R must be finished before step Y can begin.\n" +
                "Step N must be finished before step T can begin.\n" +
                "Step C must be finished before step L can begin.\n" +
                "Step F must be finished before step B can begin.\n" +
                "Step L must be finished before step D can begin.\n" +
                "Step T must be finished before step D can begin.\n" +
                "Step O must be finished before step E can begin.\n" +
                "Step M must be finished before step Z can begin.\n" +
                "Step A must be finished before step V can begin.\n" +
                "Step K must be finished before step D can begin.\n" +
                "Step W must be finished before step I can begin.\n" +
                "Step B must be finished before step J can begin.\n" +
                "Step H must be finished before step D can begin.\n" +
                "Step P must be finished before step J can begin.\n" +
                "Step J must be finished before step Z can begin.\n" +
                "Step S must be finished before step X can begin.\n" +
                "Step Z must be finished before step U can begin.\n" +
                "Step Y must be finished before step E can begin.\n" +
                "Step V must be finished before step I can begin.\n" +
                "Step U must be finished before step Q can begin.\n" +
                "Step Q must be finished before step D can begin.\n" +
                "Step X must be finished before step I can begin.\n" +
                "Step G must be finished before step E can begin.\n" +
                "Step I must be finished before step D can begin.\n" +
                "Step D must be finished before step E can begin.\n" +
                "Step B must be finished before step S can begin.\n" +
                "Step U must be finished before step E can begin.\n" +
                "Step J must be finished before step G can begin.\n" +
                "Step I must be finished before step E can begin.\n" +
                "Step N must be finished before step G can begin.\n" +
                "Step P must be finished before step Z can begin.\n" +
                "Step X must be finished before step D can begin.\n" +
                "Step H must be finished before step V can begin.\n" +
                "Step Q must be finished before step E can begin.\n" +
                "Step Z must be finished before step D can begin.\n" +
                "Step V must be finished before step D can begin.\n" +
                "Step S must be finished before step Q can begin.\n" +
                "Step F must be finished before step O can begin.\n" +
                "Step F must be finished before step M can begin.\n" +
                "Step W must be finished before step B can begin.\n" +
                "Step J must be finished before step X can begin.\n" +
                "Step G must be finished before step D can begin.\n" +
                "Step R must be finished before step K can begin.\n" +
                "Step L must be finished before step Y can begin.\n" +
                "Step J must be finished before step Q can begin.\n" +
                "Step Z must be finished before step E can begin.\n" +
                "Step Y must be finished before step Q can begin.\n" +
                "Step K must be finished before step P can begin.\n" +
                "Step N must be finished before step B can begin.\n" +
                "Step Q must be finished before step I can begin.\n" +
                "Step P must be finished before step U can begin.\n" +
                "Step F must be finished before step J can begin.\n" +
                "Step L must be finished before step G can begin.\n" +
                "Step Q must be finished before step X can begin.\n" +
                "Step H must be finished before step G can begin.\n" +
                "Step C must be finished before step O can begin.\n" +
                "Step V must be finished before step G can begin.\n" +
                "Step M must be finished before step G can begin.\n" +
                "Step A must be finished before step Z can begin.\n" +
                "Step C must be finished before step A can begin.\n" +
                "Step N must be finished before step P can begin.\n" +
                "Step N must be finished before step L can begin.\n" +
                "Step W must be finished before step E can begin.\n" +
                "Step N must be finished before step U can begin.\n" +
                "Step A must be finished before step U can begin.\n" +
                "Step O must be finished before step G can begin.\n" +
                "Step Y must be finished before step X can begin.\n" +
                "Step P must be finished before step S can begin.\n" +
                "Step Z must be finished before step Q can begin.\n" +
                "Step K must be finished before step S can begin.\n" +
                "Step N must be finished before step Z can begin.\n" +
                "Step Z must be finished before step V can begin.\n" +
                "Step P must be finished before step Y can begin.\n" +
                "Step L must be finished before step I can begin.\n" +
                "Step O must be finished before step P can begin.\n" +
                "Step N must be finished before step A can begin.\n" +
                "Step F must be finished before step A can begin.\n" +
                "Step P must be finished before step E can begin.\n" +
                "Step Z must be finished before step X can begin.\n" +
                "Step O must be finished before step A can begin.\n" +
                "Step F must be finished before step K can begin.\n" +
                "Step T must be finished before step U can begin.\n" +
                "Step Z must be finished before step I can begin.\n" +
                "Step N must be finished before step O can begin.\n" +
                "Step K must be finished before step U can begin.\n" +
                "Step M must be finished before step W can begin.\n" +
                "Step O must be finished before step U can begin.\n" +
                "Step S must be finished before step I can begin.\n" +
                "Step N must be finished before step K can begin.\n" +
                "Step O must be finished before step J can begin.\n" +
                "Step C must be finished before step J can begin.\n" +
                "Step W must be finished before step S can begin.\n" +
                "Step W must be finished before step J can begin.\n" +
                "Step H must be finished before step J can begin.\n" +
                "Step G must be finished before step I can begin.\n" +
                "Step V must be finished before step U can begin.\n" +
                "Step O must be finished before step H can begin.\n" +
                "Step F must be finished before step Y can begin.\n" +
                "Step U must be finished before step D can begin.\n" +
                "Step N must be finished before step E can begin.\n" +
                "Step H must be finished before step P can begin.");
        assert result.equals("CFMNLOAHRKPTWBJSYZVGUQXIDE") : "unexpected result is " + result;
        System.out.println(result);
    }

    private static String test(String s) {
        Pattern pattern = Pattern.compile("Step (.) must be finished before step (.) can begin\\.");

        Map<String, Node> nodes = new HashMap<>();

        String[] commands = s.split("\n");
        for (String command : commands) {
            Matcher matcher = pattern.matcher(command);
            assert matcher.matches() : "not matches " + command;

            String from = matcher.group(1);
            String to = matcher.group(2);

            nodes.computeIfAbsent(from, key -> new Node(key));
            nodes.computeIfAbsent(to, key -> new Node(key));

            Node parent = nodes.get(from);
            Node child = nodes.get(to);

            parent.children.add(child);
            child.parents.add(parent);
        }

        // just for information
        List<Node> roots = new ArrayList<>();
        for (Node node : nodes.values()) {
            if (node.parents.isEmpty()) {
                System.out.println("root is " + node.name + " " + node.children);
                roots.add(node);
            }
        }
        assert !roots.isEmpty() : "no roots found";

        // just for information
        Node finish = null;
        for (Node node : nodes.values()) {
            if (node.children.isEmpty()) {
                assert finish == null : "must be one finish node";
                System.out.println("finish node is " + node.name);
                finish = node;
            }
        }
        assert finish != null : "no finish node found";

        String result = "";
        List<Node> opened = new ArrayList<>(nodes.values());
        while (!opened.isEmpty()) {
            List<Node> available = new ArrayList<>();
            for (Node node : opened) {
                if (!node.leet && allNodesLeet(node.parents)) {
                    available.add(node);
                }
            }
            Collections.sort(available, (o1, o2) -> o1.name.compareTo(o2.name));
            if (available.isEmpty()) {
                break;
            }
            Node first = available.remove(0);
            opened.remove(first);
            first.leet = true;
            result += first.name;
        }

        assert result.length() == nodes.size() : "invalid answer " + result;
        for (int i = 0; i < result.length() - 1; ++i) {
            char ch1 = result.charAt(i);
            for (int j = i + 1; j < result.length(); ++j) {
                char ch2 = result.charAt(j);
                assert ch1 != ch2 : "invalid answer " + result;
            }
        }

        return result;
    }

    private static boolean allNodesLeet(Collection<Node> nodes) {
        for (Node node : nodes) {
            if (!node.leet) {
                return false;
            }
        }
        return true;
    }

    private static class Node {
        String name;
        boolean leet;
        List<Node> children = new ArrayList<>();
        List<Node> parents = new ArrayList<>();

        Node(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
