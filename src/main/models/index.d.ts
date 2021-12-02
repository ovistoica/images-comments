import { ModelInit, MutableModel, PersistentModelConstructor } from "@aws-amplify/datastore";





export declare class Task {
  readonly id: string;
  readonly title: string;
  readonly description?: string;
  readonly status?: string;
  readonly createdAt?: string;
  readonly updatedAt?: string;
  constructor(init: ModelInit<Task>);
  static copyOf(source: Task, mutator: (draft: MutableModel<Task>) => MutableModel<Task> | void): Task;
}

export declare class PrivateNote {
  readonly id: string;
  readonly content: string;
  readonly createdAt?: string;
  readonly updatedAt?: string;
  constructor(init: ModelInit<PrivateNote>);
  static copyOf(source: PrivateNote, mutator: (draft: MutableModel<PrivateNote>) => MutableModel<PrivateNote> | void): PrivateNote;
}

export declare class Design {
  readonly id: string;
  readonly name: string;
  readonly context: string;
  readonly createdAt?: string;
  readonly updatedAt?: string;
  constructor(init: ModelInit<Design>);
  static copyOf(source: Design, mutator: (draft: MutableModel<Design>) => MutableModel<Design> | void): Design;
}