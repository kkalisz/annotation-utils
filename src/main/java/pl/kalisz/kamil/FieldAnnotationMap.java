package pl.kalisz.kamil;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/*
 * Copyright (C) 2014 Kamil Kalisz.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class FieldAnnotationMap<V extends Annotation> implements Serializable, Iterable<FieldAnnotationInfo<V>>
{
    private List<FieldAnnotationInfo<V>> fieldAnnotationInfoList = new ArrayList<FieldAnnotationInfo<V>>();

    void add(FieldAnnotationInfo<V> info)
    {
        fieldAnnotationInfoList.add(info);
    }

    void addAll(Collection<FieldAnnotationInfo<V>> infos)
    {
        fieldAnnotationInfoList.addAll(infos);
    }

    @Override
    public Iterator<FieldAnnotationInfo<V>> iterator()
    {
        return fieldAnnotationInfoList.iterator();
    }
    
    public List<FieldAnnotationInfo<V>> getFieldsInfo()
    {
        return fieldAnnotationInfoList;
    }

    public void add(FieldAnnotationMap<V> fieldAnnotationMap)
    {
        fieldAnnotationInfoList.addAll(fieldAnnotationMap.getFieldsInfo());
    }
}
