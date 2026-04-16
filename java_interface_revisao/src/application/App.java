
void main() {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    LocalDateTime d1 = LocalDateTime.parse("16/04/2026 10:30", dtf);
    LocalDateTime d2 = LocalDateTime.parse("16/04/2026 14:40", dtf);

    long d = ChronoUnit.SECONDS.between(d1, d2);
    double hours = (double) d / 60 / 60;
    System.out.println(hours);

    Duration duration = Duration.between(d1, d2);
    double hour = (double) duration.toMinutes() / 60;
    System.out.println(hour);
}