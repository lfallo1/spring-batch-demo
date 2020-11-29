package com.lancefallon.springbatchhelloworld.config.batch.reader.filereader.mapper;

import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.LineTokenizer;

public interface FileLineMapper<T> {
    LineMapper lineMapper();

    FieldSetMapper fieldMapper();

    LineTokenizer delimittedTokenizer();
}
