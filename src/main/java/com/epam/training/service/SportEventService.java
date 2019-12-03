package com.epam.training.service;

import com.epam.training.domain.SportEvent;
import com.epam.training.service.common.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class SportEventService extends CrudServiceImpl<SportEvent, String> {
}
