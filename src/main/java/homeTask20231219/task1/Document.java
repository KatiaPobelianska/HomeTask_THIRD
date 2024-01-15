package homeTask20231219.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/*1 Разработайте программу, эмулирующую работу нескольких пользователей (потоков)
с единым электронным документом. Все пользователи могут добавлять, редактировать и удалять
записи (одна запись – одна строка). Каждый новый пользователь получает актуальную копию документа и
 работает с ней. После внесения изменений пользователь сохраняет изменения.
Для оптимизации доступа к документу используйте ReentrantReadWriteLock.*/
public class Document {
    private final List<String> lines = new ArrayList<>();
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public List<String> getLines(){
        lock.readLock().lock();
        try {
            return new ArrayList<>(lines);
        }finally {
            lock.readLock().unlock();
        }
    }
    public void addLine(String line) {
        lock.writeLock().lock();
        try {
            lines.add(line);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void changeLine(int index, String newLine) {
        lock.writeLock().lock();
        try {
            if (index >= 0 && index < lines.size()) {
                lines.set(index, newLine);
            }
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void deleteLine(int index) {
        lock.writeLock().lock();
        try {
            if (index >= 0 && index < lines.size()){
                lines.remove(index);
            }
        } finally {
            lock.writeLock().unlock();
        }
    }
}
