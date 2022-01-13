# Developer Guide

This section describes a few key areas for developers to understand the code.

# Design Patterns

__Parser__  
The parser uses the `builder` pattern to parse the text input from the user. All command parsers must extend the abstract class `draw.parser.command.CommandParser` and make use of the `draw.parser.ParsedCommandBuilder` to implement the `parse` method. This will return a `draw.parse.ParsedCommand` object which will then be subsequently handed over to the controller.

__Command__  
The commands are implemented using the `command` pattern. All commands must extend the abstract class `draw.command.Command` and implement the `execute` method. Commands will then be invoked by the `draw.cli.Controller` through their `execute` methods. All Commands are also expected to be able to process their inputs through the `ParsedCommand` object, which is a set of processed input parameters by the parser.

# Dependencies

This project makes use of the following dependencies:

1. Lombok - Annotation based library to automatically generate boilerplate code.
2. System Rules - JUnit library for testing System Rules like System.exit(0).  

# Making Changes 

__Adding new commands__  
To add new commands, you will have to create a new `CommandParser`, `Command` and whatever necessary `model` objects.

In addition, you will also have to modify the Controller and Parser to be able to recognize your new commands. Specifically,  
  
In the `Controller`, add your new `Command` object to the `findCommand` method.  
In the `Parser`, add your new `CommandParser` object to the `parse` method and CommandAttributes array.  
In the `ParsedCommand`, add your new `CommandType` to the CommandType enum.  

