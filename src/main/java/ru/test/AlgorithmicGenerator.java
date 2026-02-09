//package ru.test;
//
//import java.security.SecureRandom;
//import java.util.ArrayList;
//
//public class AlgorithmicGenerator {
//    private static final SecureRandom random = new SecureRandom();
//
//    public static String generateUserId() {
//        // Алгоритм: timestamp + hex(8 байт) + короткий hash
//        long timestamp = System.currentTimeMillis();
//        byte[] bytes = new byte[8];
//        random.nextBytes(bytes);
//        String hex = bytesToHex(bytes).substring(0, 16);
//        return String.format("%d_%s", timestamp % 1000000, hex);
//    }
//
//    private static String bytesToHex(byte[] bytes) {
//        StringBuilder sb = new StringBuilder();
//        for (byte b : bytes) {
//            sb.append(String.format("%02x", b));
//        }
//        return sb.toString();
//    }
//
//    public static String generateEmail(String baseName, int userIndex) {
//        // Алгоритм Luhn-like для реалистичных номеров + домены
//        String[] domains = {"gmail.com", "yandex.ru", "mail.ru", "example.com"};
//        String number = luhnGenerate(8); // 8-значный "валидный" номер
//        return String.format("%s_%s_%s@%s",
//                baseName, userIndex, number, domains[userIndex % domains.length]);
//    }
//
//    private static String luhnGenerate(int length) {
//        // Алгоритм Luhn для "валидных" номеров карт/email
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < length - 1; i++) {
//            sb.append(random.nextInt(10));
//        }
//        // Последняя цифра по алгоритму Luhn
//        int sum = 0;
//        for (int i = sb.length() - 1; i >= 0; i--) {
//            int digit = sb.charAt(i) - '0';
//            if ((sb.length() - i) % 2 == 0) digit *= 2;
//            if (digit > 9) digit -= 9;
//            sum += digit;
//        }
//        int checkDigit = (10 - (sum % 10)) % 10;
//        return sb.append(checkDigit).toString();
//    }
//
//    public static List<Task> generateTaskHierarchy(int levels, int branchingFactor) {
//        List<Task> tasks = new ArrayList<>();
//
//        // Корень проекта
//        Task root = Task.builder()
//                .id("TASK_0001")
//                .name("Epic Project")
//                .priority(1)
//                .parentId(null)
//                .build();
//        tasks.add(root);
//
//        generateTaskTree(tasks, root.getId(), levels, branchingFactor, 2);
//        return tasks;
//    }
//
//    private static void generateTaskTree(List<Task> tasks, String parentId,
//                                         int remainingLevels, int branching, int priority) {
//        if (remainingLevels <= 0) return;
//
//        int taskCount = random.nextInt(1, branching + 1);
//        for (int i = 0; i < taskCount; i++) {
//            String taskId = String.format("TASK_%04d", tasks.size() + 1);
//            Task task = Task.builder()
//                    .id(taskId)
//                    .name(String.format("Task L%d_%d", tasks.size() - 1, i))
//                    .priority(priority + random.nextInt(5))
//                    .parentId(parentId)
//                    .estimatedHours(4 + random.nextInt(40))
//                    .build();
//            tasks.add(task);
//
//            generateTaskTree(tasks, taskId, remainingLevels - 1, branching, priority + 1);
//        }
//
//        public static List<Task> generateTaskHierarchy(int levels, int branchingFactor) {
//            List<Task> tasks = new ArrayList<>();
//
//            // Корень проекта
//            Task root = Task.builder()
//                    .id("TASK_0001")
//                    .name("Epic Project")
//                    .priority(1)
//                    .parentId(null)
//                    .build();
//            tasks.add(root);
//
//            generateTaskTree(tasks, root.getId(), levels, branchingFactor, 2);
//            return tasks;
//        }
//
//        private static void generateTaskTree(List<Task> tasks, String parentId,
//        int remainingLevels, int branching, int priority) {
//            if (remainingLevels <= 0) return;
//
//            int taskCount = random.nextInt(1, branching + 1);
//            for (int i = 0; i < taskCount; i++) {
//                String taskId = String.format("TASK_%04d", tasks.size() + 1);
//                Task task = Task.builder()
//                        .id(taskId)
//                        .name(String.format("Task L%d_%d", tasks.size() - 1, i))
//                        .priority(priority + random.nextInt(5))
//                        .parentId(parentId)
//                        .estimatedHours(4 + random.nextInt(40))
//                        .build();
//                tasks.add(task);
//
//                generateTaskTree(tasks, taskId, remainingLevels - 1, branching, priority + 1);
//            }
//        }
//
//    }
//
//
//}
//
