package com.epam.training.domain;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Inheritance(strategy = InheritanceType.JOINED)
public class TennisSportEvent extends SportEvent {
}
