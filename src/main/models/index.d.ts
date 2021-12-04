import { ModelInit, MutableModel, PersistentModelConstructor } from "@aws-amplify/datastore";





type DesignMetaData = {
  readOnlyFields: 'createdAt' | 'updatedAt';
}

type ShotMetaData = {
  readOnlyFields: 'createdAt' | 'updatedAt';
}

export declare class Design {
  readonly id: string;
  readonly name: string;
  readonly context: string;
  readonly shots?: Shot[];
  readonly createdAt?: string;
  readonly updatedAt?: string;
  constructor(init: ModelInit<Design, DesignMetaData>);
  static copyOf(source: Design, mutator: (draft: MutableModel<Design, DesignMetaData>) => MutableModel<Design, DesignMetaData> | void): Design;
}

export declare class Shot {
  readonly id: string;
  readonly url: string;
  readonly design?: Design;
  readonly createdAt?: string;
  readonly updatedAt?: string;
  constructor(init: ModelInit<Shot, ShotMetaData>);
  static copyOf(source: Shot, mutator: (draft: MutableModel<Shot, ShotMetaData>) => MutableModel<Shot, ShotMetaData> | void): Shot;
}