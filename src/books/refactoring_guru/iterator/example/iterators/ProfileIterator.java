package books.refactoring_guru.iterator.example.iterators;

import books.refactoring_guru.iterator.example.profile.Profile;

public interface ProfileIterator {
    boolean hasNext();

    Profile getNext();

    void reset();
}