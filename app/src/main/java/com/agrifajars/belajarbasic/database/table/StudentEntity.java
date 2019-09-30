package com.agrifajars.belajarbasic.database.table;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class StudentEntity implements Serializable, List {
    @PrimaryKey(autoGenerate = true)
    int id;
    @ColumnInfo(name = "nis")
    String nis;
    @ColumnInfo(name = "name")
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(@Nullable Object o) {
        return false;
    }

    @NonNull
    @Override
    public Iterator iterator() {
        return null;
    }

    @Nullable
    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(@Nullable Object o) {
        return false;
    }

    @Override
    public boolean addAll(@NonNull Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, @NonNull Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public int indexOf(@Nullable Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(@Nullable Object o) {
        return 0;
    }

    @NonNull
    @Override
    public ListIterator listIterator() {
        return null;
    }

    @NonNull
    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @NonNull
    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(@NonNull Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(@NonNull Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(@NonNull Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(@Nullable Object[] a) {
        return new Object[0];
    }
}
