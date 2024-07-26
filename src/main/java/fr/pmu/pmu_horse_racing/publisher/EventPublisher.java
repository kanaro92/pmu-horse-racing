package fr.pmu.pmu_horse_racing.publisher;

public interface EventPublisher<T> {
    void publish(T t);
}
