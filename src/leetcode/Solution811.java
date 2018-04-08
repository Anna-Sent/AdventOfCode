class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] parts = cpdomain.split(" ");
            int count = Integer.parseInt(parts[0]);
            String[] domainParts = parts[1].split("\\.");
            for (int i = 0; i < domainParts.length; ++i) {
                StringBuilder domainBuilder = new StringBuilder();
                for (int j = i; j < domainParts.length; ++j) {
                    domainBuilder.append(domainParts[j]);
                    domainBuilder.append(j == domainParts.length - 1 ? "" : ".");
                }
                String domain = domainBuilder.toString();
                Integer oldCount = map.get(domain);
                int newCount = oldCount == null ? count : oldCount + count;
                map.put(domain, newCount);
            }
        }
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        List<String> result = new ArrayList<>();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            result.add(entry.getValue() + " " + entry.getKey());
        }
        return result;
    }
}
