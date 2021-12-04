/* eslint-disable */
// this is an auto generated file. This will be overwritten
// noinspection GraphQLUnresolvedReference

export const getShot = /* GraphQL */ `
  query GetShot($id: ID!) {
    getShot(id: $id) {
      id
      url
      designID
      design {
        id
        name
        context
        shots {
          nextToken
          startedAt
        }
        createdAt
        updatedAt
        _version
        _deleted
        _lastChangedAt
        owner
      }
      createdAt
      updatedAt
      _version
      _deleted
      _lastChangedAt
      owner
    }
  }
`;
export const listShots = /* GraphQL */ `
  query ListShots(
    $filter: ModelShotFilterInput
    $limit: Int
    $nextToken: String
  ) {
    listShots(filter: $filter, limit: $limit, nextToken: $nextToken) {
      items {
        id
        url
        designID
        design {
          id
          name
          context
          createdAt
          updatedAt
          _version
          _deleted
          _lastChangedAt
          owner
        }
        createdAt
        updatedAt
        _version
        _deleted
        _lastChangedAt
        owner
      }
      nextToken
      startedAt
    }
  }
`;
export const syncShots = /* GraphQL */ `
  query SyncShots(
    $filter: ModelShotFilterInput
    $limit: Int
    $nextToken: String
    $lastSync: AWSTimestamp
  ) {
    syncShots(
      filter: $filter
      limit: $limit
      nextToken: $nextToken
      lastSync: $lastSync
    ) {
      items {
        id
        url
        designID
        design {
          id
          name
          context
          createdAt
          updatedAt
          _version
          _deleted
          _lastChangedAt
          owner
        }
        createdAt
        updatedAt
        _version
        _deleted
        _lastChangedAt
        owner
      }
      nextToken
      startedAt
    }
  }
`;
export const getDesign = /* GraphQL */ `
  query GetDesign($id: ID!) {
    getDesign(id: $id) {
      id
      name
      context
      shots {
        items {
          id
          url
          designID
          createdAt
          updatedAt
          _version
          _deleted
          _lastChangedAt
          owner
        }
        nextToken
        startedAt
      }
      createdAt
      updatedAt
      _version
      _deleted
      _lastChangedAt
      owner
    }
  }
`;
export const listDesigns = /* GraphQL */ `
  query ListDesigns(
    $filter: ModelDesignFilterInput
    $limit: Int
    $nextToken: String
  ) {
    listDesigns(filter: $filter, limit: $limit, nextToken: $nextToken) {
      items {
        id
        name
        context
        shots {
          nextToken
          startedAt
        }
        createdAt
        updatedAt
        _version
        _deleted
        _lastChangedAt
        owner
      }
      nextToken
      startedAt
    }
  }
`;
export const syncDesigns = /* GraphQL */ `
  query SyncDesigns(
    $filter: ModelDesignFilterInput
    $limit: Int
    $nextToken: String
    $lastSync: AWSTimestamp
  ) {
    syncDesigns(
      filter: $filter
      limit: $limit
      nextToken: $nextToken
      lastSync: $lastSync
    ) {
      items {
        id
        name
        context
        shots {
          nextToken
          startedAt
        }
        createdAt
        updatedAt
        _version
        _deleted
        _lastChangedAt
        owner
      }
      nextToken
      startedAt
    }
  }
`;
